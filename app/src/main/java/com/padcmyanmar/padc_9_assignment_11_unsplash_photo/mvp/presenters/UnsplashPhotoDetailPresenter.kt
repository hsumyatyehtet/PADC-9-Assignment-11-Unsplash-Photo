package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.presenters

import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.activity.BaseActivity
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model.UnsplashPhotoModelImpl
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view.UnsplashPhotoDetailView

class UnsplashPhotoDetailPresenter: BasePresenter<UnsplashPhotoDetailView>() {

    fun onUIReady(unsphashPhotoId: String,activity: BaseActivity){
        if (unsphashPhotoId!=null){
            val model: UnsplashPhotoModelImpl = UnsplashPhotoModelImpl
            model.getUnsplashPhotosById(unsphashPhotoId)
                .observe(activity,androidx.lifecycle.Observer {
                    mView.displayUnplashPhotoData(it)
                })
        }
    }
}