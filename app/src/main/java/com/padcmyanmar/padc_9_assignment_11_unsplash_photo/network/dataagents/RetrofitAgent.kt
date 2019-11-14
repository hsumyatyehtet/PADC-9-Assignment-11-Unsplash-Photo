package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.network.dataagents

import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.network.PhotoApi
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.utils.BASE_URL
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.utils.EM_NULL_PHOTO_RESPONSE
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

object RetrofitAgent : UnsplashPhotoDataAgent {

    private val photoApi: PhotoApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        photoApi = retrofit.create(PhotoApi::class.java)
    }

    override fun getPhotos(
        onSuccess: (List<UnsplashVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = photoApi.getAllPhotos()
        call.enqueue(object : Callback<List<UnsplashVO>> {
            override fun onFailure(call: Call<List<UnsplashVO>>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<UnsplashVO>>,
                response: Response<List<UnsplashVO>>
            ) {
                val photoResponse = response.body()
                if (photoResponse != null) {
                    onSuccess(photoResponse)
                } else {
                    onFailure(EM_NULL_PHOTO_RESPONSE)
                }
            }

        })
    }

    override fun getPhotosObservable(): Observable<List<UnsplashVO>> {
        return photoApi.getAllPhotosObservable()
            .flatMap<List<UnsplashVO>> {
                val data = it
                if (data == null) {
                    Observable.error(RuntimeException())
                } else {
                    Observable.just(data)
                }
            }
    }

}