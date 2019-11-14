package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.network

import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.utils.ACCESS_KEY
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.utils.ENDPOINT_ALL_PHOTOS
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET(ENDPOINT_ALL_PHOTOS)
    fun getAllPhotos(@Query("client_id") clientId: String = ACCESS_KEY): Call<List<UnsplashVO>>

    @GET(ENDPOINT_ALL_PHOTOS)
    fun getAllPhotosObservable(@Query("client_id")clientId: String = ACCESS_KEY): Observable<List<UnsplashVO>>
}