package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model

import androidx.lifecycle.LiveData
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO

interface UnsplashPhotoModel {

//    fun getUnsplashPhotos(
//        onSuccess: (List<UnsplashVO>) -> Unit,
//        onFailure: (String) -> Unit
//    )

    fun getUnsplashPhotos(onFailure: (String) -> Unit): LiveData<List<UnsplashVO>>

    fun getUnsplashPhotosById(photoId: String): LiveData<UnsplashVO>
}