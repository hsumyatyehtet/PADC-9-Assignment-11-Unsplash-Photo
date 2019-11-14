package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model.UnsplashPhotoModel
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model.UnsplashPhotoModelImpl

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var model: UnsplashPhotoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model=UnsplashPhotoModelImpl
    }
}