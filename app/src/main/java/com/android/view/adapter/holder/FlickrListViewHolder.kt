package com.android.view.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.android.R

/**
 * Created by user on 2017-06-09.
 */
class FlickrListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val flickrImg by lazy {
        itemView?.findViewById(R.id.flickr_img) as ImageView
    }
}