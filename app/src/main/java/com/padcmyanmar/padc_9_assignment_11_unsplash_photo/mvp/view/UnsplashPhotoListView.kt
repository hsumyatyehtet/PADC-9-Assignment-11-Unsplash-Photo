package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view

import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO

interface UnsplashPhotoListView: BaseView {

    fun displayUnsplashPhtoList(unsplashPhotoList: List<UnsplashVO>)
    fun displayError(errorMessage: String)
    fun navigateToDetail(unplashPhotoID: String)
}