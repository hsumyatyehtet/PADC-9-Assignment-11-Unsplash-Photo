package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.R
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.delegate.UnsplashPhotoItemDelegate
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.holder.PhotoItemViewHolder

class PhotoItemAdapter(private val delegate: UnsplashPhotoItemDelegate): BaseRecyclerAdapter<PhotoItemViewHolder,UnsplashVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.main_grid_item,parent,false)
        return PhotoItemViewHolder(view,delegate)
    }

}