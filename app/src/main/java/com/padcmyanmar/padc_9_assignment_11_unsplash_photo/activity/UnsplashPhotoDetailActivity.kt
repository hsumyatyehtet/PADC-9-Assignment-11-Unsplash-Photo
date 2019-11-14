package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.R
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.fragment.DetailBottomSheetFragment
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.presenters.UnsplashPhotoDetailPresenter
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view.UnsplashPhotoDetailView
import kotlinx.android.synthetic.main.activity_detail.*

class UnsplashPhotoDetailActivity : BaseActivity(), UnsplashPhotoDetailView {

    override fun displayUnplashPhotoData(upshlashData: UnsplashVO) {

    }

    private lateinit var mUnsplashPhotoDetailPresenter: UnsplashPhotoDetailPresenter

    companion object {
        const val EXTRA_PHOTO_ID: String = "PhotoIdExtra"

        fun newIntent(context: Context, photoIdExtra: String): Intent {

            return Intent(context, UnsplashPhotoDetailActivity::class.java).apply {
                putExtra(EXTRA_PHOTO_ID, photoIdExtra)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mUnsplashPhotoDetailPresenter = UnsplashPhotoDetailPresenter()
        mUnsplashPhotoDetailPresenter.initPresenter(this)

        val photoId = intent.getStringExtra(EXTRA_PHOTO_ID)
        mUnsplashPhotoDetailPresenter.onUIReady(photoId, this)

        if (photoId!=null){
            val photoVO = model.getUnsplashPhotosById(photoId)
           // bindData(photoVO)
        }

        iv_detail_cover.setOnClickListener {
            val bottomSheet = DetailBottomSheetFragment()
            bottomSheet.show(supportFragmentManager, "Bottom Sheet")
        }

    }

    private fun bindData(photoVO: UnsplashVO) {
        Glide.with(this)
            .load(photoVO.unsplashUrlVo)
            .into(iv_detail_cover)
    }

}