package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view.BaseView

abstract class BasePresenter<T : BaseView> : ViewModel() {

    protected lateinit var mView: T

    open fun initPresenter(view: T) {
        this.mView = view
    }

}