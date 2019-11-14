package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.GridItemDecoration
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.R
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.adapter.PhotoDetailItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_bottom_sheet.*
import kotlinx.android.synthetic.main.detail_bottom_sheet.view.*

class DetailBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var mPhotoDetailItemAdapter: PhotoDetailItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_bottom_sheet, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPhotoDetailItemAdapter = PhotoDetailItemAdapter()

        with(recycler_view_dialog) {
            recycler_view_dialog.setHasFixedSize(true)
            recycler_view_dialog.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recycler_view_dialog.addItemDecoration(GridItemDecoration(10, 2))
            adapter = mPhotoDetailItemAdapter
        }

    }

}