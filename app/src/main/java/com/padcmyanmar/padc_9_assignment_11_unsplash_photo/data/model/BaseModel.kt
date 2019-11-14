package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.model

import android.content.Context
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.network.dataagents.RetrofitAgent
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.persistance.UnsplashDatabase

abstract class BaseModel {

    protected val dataAgent = RetrofitAgent

    protected lateinit var database: UnsplashDatabase

    public fun initDatabase(context: Context){
        database= UnsplashDatabase.getInstance(context)
    }
}