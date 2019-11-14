package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.delegate.UnsplashPhotoItemDelegate
import kotlinx.android.synthetic.main.main_grid_item.view.*
import java.util.*


class PhotoItemViewHolder(itemView: View, private val delegate: UnsplashPhotoItemDelegate) :
    BaseViewHolder<UnsplashVO>(itemView) {

    init {
        itemView.setOnClickListener {
            val id = data?.id
            id?.let { id ->
                delegate.onTapUnsplashPhotoItem(id)
            }
        }
    }

//    private val mRandom = Random()
//
//    private fun getRandomInRange(max: Int, min: Int): Int {
//        return mRandom.nextInt(max - min + min) + min
//    }

    override fun bindData(data: UnsplashVO) {
        Glide.with(itemView)
            .load(data.unsplashUrlVo.regularPhoto)
            .into(itemView.iv_main_grid)
    }
}