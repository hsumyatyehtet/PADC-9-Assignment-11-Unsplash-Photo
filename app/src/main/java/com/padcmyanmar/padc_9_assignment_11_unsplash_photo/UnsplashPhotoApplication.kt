package com.padcmyanmar.padc_9_assignment_11_unsplash_photo

import android.app.Application
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model.UnsplashPhotoModelImpl

class UnsplashPhotoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        UnsplashPhotoModelImpl.initDatabase(applicationContext)
    }
}