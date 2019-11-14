package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class UnsplashPhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUnsplashPhotos(photos: List<UnsplashVO>): Single<LongArray>

    @Query("SELECT * FROM unsplash")
    abstract fun getAllUnsplashPhotos(): LiveData<List<UnsplashVO>>

    @Query("SELECT * FROM unsplash")
    abstract fun getAllUnsplashPhotosMaybe(): Maybe<List<UnsplashVO>>

    @Query("SELECT * FROM unsplash WHERE id= :id")
    abstract fun getUnsplahsPhotoById(id: String): LiveData<UnsplashVO>
}