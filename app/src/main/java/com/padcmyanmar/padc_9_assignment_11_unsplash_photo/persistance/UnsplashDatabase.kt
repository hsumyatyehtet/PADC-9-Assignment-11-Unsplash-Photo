package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.persistance.dao.UnsplashPhotoDao
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.utils.UNSPLASH_DB

@Database(entities = [UnsplashVO::class], version = 1, exportSchema = false)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unSplashPhotoDao(): UnsplashPhotoDao

    companion object {
        private var instance: UnsplashDatabase? = null

        fun getInstance(context: Context): UnsplashDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, UnsplashDatabase::class.java, UNSPLASH_DB)
                    .fallbackToDestructiveMigration()
                    .build()
            }

            val db = instance!!

            return db
        }
    }
}