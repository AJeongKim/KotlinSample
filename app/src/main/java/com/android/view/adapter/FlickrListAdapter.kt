package com.android.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.R
import com.android.data.FlickrPhotoData
import com.android.view.adapter.holder.FlickrListViewHolder
import com.bumptech.glide.Glide

/**
 * Created by user on 2017-06-09.
 */
class FlickrListAdapter(val context: Context, var photoDataList: ArrayList<FlickrPhotoData>)
    : RecyclerView.Adapter<FlickrListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FlickrListViewHolder {
        return FlickrListViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_flickr_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: FlickrListViewHolder?, position: Int) {
        val url = photoDataList.get(position).createUrl()
        Glide.with(context).load(url).placeholder(R.drawable.loading).into(holder?.flickrImg)
    }

    override fun getItemCount(): Int {
        return photoDataList.size
    }

    fun addItem(list : ArrayList<FlickrPhotoData>) {
        photoDataList = list
    }
}