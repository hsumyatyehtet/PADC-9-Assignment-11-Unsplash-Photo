package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view

import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO

interface UnsplashPhotoDetailView: BaseView {

    fun displayUnplashPhotoData(upshlashData: UnsplashVO)
}