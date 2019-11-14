package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.utils.EM_NULL_PHOTO_RESPONSE
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UnsplashPhotoModelImpl : BaseModel(), UnsplashPhotoModel {

//    override fun getUnsplashPhotos(
//        onSuccess: (List<UnsplashVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        dataAgent.getPhotos(
//            {
//                onSuccess(it)
//            }, onFailure
//        )
//    }

    override fun getUnsplashPhotos(onFailure: (String) -> Unit): LiveData<List<UnsplashVO>> {
        val databaseSingle = database.unSplashPhotoDao().getAllUnsplashPhotosMaybe().subscribeOn(Schedulers.io())
            .flatMap {
                if (it.isEmpty())Maybe.empty()
                else Maybe.just(it)
            }

        val networkObersable=dataAgent.getPhotosObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                onFailure(it.message ?: EM_NULL_PHOTO_RESPONSE)
            }

        Observable.concat(databaseSingle.toObservable(),networkObersable)
            .firstElement()
            .flatMap<LongArray> {
                database.unSplashPhotoDao().insertUnsplashPhotos(it).subscribeOn(Schedulers.io()).toMaybe()
            }
            .subscribe({
                Log.d("Room",it.toString())
            },
                {
                onFailure(it.message?: EM_NULL_PHOTO_RESPONSE)
                    Log.e("Room",it.localizedMessage)
            }
            )

        val unsplashPhotoFromDB = database.unSplashPhotoDao().getAllUnsplashPhotos()
        return Transformations.distinctUntilChanged(unsplashPhotoFromDB)

    }

    override fun getUnsplashPhotosById(photoId: String): LiveData<UnsplashVO> {
        return Transformations.distinctUntilChanged(
            database.unSplashPhotoDao().getUnsplahsPhotoById(photoId)
        )
    }

}