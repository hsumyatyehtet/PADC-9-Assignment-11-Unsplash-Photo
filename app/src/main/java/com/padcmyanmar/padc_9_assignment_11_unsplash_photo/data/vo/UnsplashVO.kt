package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "unsplash")
data class UnsplashVO(

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: String,

    @SerializedName("width")
    @ColumnInfo(name = "width")
    var width: Long,

    @SerializedName("height")
    @ColumnInfo(name = "height")
    var height: Long,

    @SerializedName("urls")
    @Embedded(prefix = "urls_")
    var unsplashUrlVo: UnsplashUrlVO
)