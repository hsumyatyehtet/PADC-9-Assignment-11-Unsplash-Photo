package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.GridItemDecoration
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.R
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.adapter.PhotoItemAdapter
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.data.vo.UnsplashVO
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.presenters.UnsplashPhotoListPresenter
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.mvp.view.UnsplashPhotoListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), UnsplashPhotoListView {

    override fun displayError(errorMessage: String) {
        Snackbar.make(root_view, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun displayUnsplashPhtoList(unsplashPhotoList: List<UnsplashVO>) {
        mPhotoItemAdapter.setNewData(unsplashPhotoList.toMutableList())
    }

    override fun navigateToDetail(unplashPhotoID: String) {
        startActivity(UnsplashPhotoDetailActivity.newIntent(applicationContext,unplashPhotoID))
    }

    private lateinit var mPresenter: UnsplashPhotoListPresenter
    private lateinit var mPhotoItemAdapter: PhotoItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize presenter
        mPresenter = ViewModelProviders.of(this).get(UnsplashPhotoListPresenter::class.java)
        mPresenter.initPresenter(this)

        mPhotoItemAdapter = PhotoItemAdapter(mPresenter)

        with(rv_main) {
            rv_main.setHasFixedSize(true)
            rv_main.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv_main.addItemDecoration(GridItemDecoration(10, 2))
            adapter = mPhotoItemAdapter
        }

        mPresenter.onUiReady(this)

        // model = UnsplashPhotoModelImpl

//        model.getUnsplashPhotos(
//            {photos ->
//                photoAdapter.setNewData(photos.toMutableList())
//            },{
//               // Snackbar.make()
//            }
//        )

    }
}
