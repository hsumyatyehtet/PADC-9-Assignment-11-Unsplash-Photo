package com.padcmyanmar.padc_9_assignment_11_unsplash_photo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padc_9_assignment_11_unsplash_photo.holder.BaseViewHolder
import kotlinx.android.synthetic.main.main_grid_item.view.*
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {

    private val mRandom = Random()

    private fun getRandomInRange(max: Int, min: Int): Int {
        return mRandom.nextInt(max - min + min) + min
    }


    private var dataList: MutableList<T> = ArrayList()

    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.iv_main_grid.layoutParams.height=getRandomInRange(300,200)
        holder.data=dataList[position]
    }

    fun setNewData(newData: MutableList<T>){
        dataList=newData
        notifyDataSetChanged()
    }
}