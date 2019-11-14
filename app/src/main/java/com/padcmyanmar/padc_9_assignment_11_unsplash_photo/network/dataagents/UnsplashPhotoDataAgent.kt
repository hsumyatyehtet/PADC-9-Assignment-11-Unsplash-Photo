package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.network.dataagents

import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import io.reactivex.Observable


interface UnsplashPhotoDataAgent {

    fun getPhotos(
        onSuccess: (List<UnsplashVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPhotosObservable(): Observable<List<UnsplashVO>>
}