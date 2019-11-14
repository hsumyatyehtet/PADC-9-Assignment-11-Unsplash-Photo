package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class UnsplashUrlVO (

    @SerializedName("regular")
    @ColumnInfo(name = "regular")
    var regularPhoto: String
)