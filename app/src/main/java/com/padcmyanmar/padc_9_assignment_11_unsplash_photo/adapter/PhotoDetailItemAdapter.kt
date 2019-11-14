package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.R
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.holder.PhotoDetailItemViewHolder
import kotlinx.android.synthetic.main.main_grid_item.view.*
import java.util.*

class PhotoDetailItemAdapter: BaseRecyclerAdapter<PhotoDetailItemViewHolder,UnsplashVO>() {

    private val mRandom = Random()

    private fun getRandomInRange(max: Int, min: Int): Int {
        return mRandom.nextInt(max - min + min) + min
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoDetailItemViewHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.main_grid_item,parent,false)
        return PhotoDetailItemViewHolder(view)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: PhotoDetailItemViewHolder, position: Int) {
        holder.itemView.iv_main_grid.layoutParams.height=getRandomInRange(300,200)
    }
}