package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.presenters

import androidx.lifecycle.Observer
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.activity.BaseActivity
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model.UnsplashPhotoModelImpl
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.delegate.UnsplashPhotoItemDelegate
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view.UnsplashPhotoListView

class UnsplashPhotoListPresenter : BasePresenter<UnsplashPhotoListView>(),UnsplashPhotoItemDelegate {

    override fun onTapUnsplashPhotoItem(id: String) {
        mView.navigateToDetail(id)
    }

    fun onUiReady(activity: BaseActivity) {
        val model: UnsplashPhotoModelImpl = UnsplashPhotoModelImpl
        model.getUnsplashPhotos { mView.displayError(it) }
            .observe(activity, Observer {
                mView.displayUnsplashPhtoList(it)
            })
    }
}