package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.holder

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import kotlinx.android.synthetic.main.activity_detail.view.*

class PhotoDetailItemViewHolder(itemView: View): BaseViewHolder<UnsplashVO>(itemView) {

    override fun bindData(data: UnsplashVO) {
//        Glide.with(itemView)
//            .load(data.unsplashUrlVo.regularPhoto)
//            .into(itemView.iv_detail_cover)
    }

}