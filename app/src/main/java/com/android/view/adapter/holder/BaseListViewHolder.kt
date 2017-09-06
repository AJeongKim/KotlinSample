package com.android.view.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.android.R
import com.android.listener.ClickListener

class BaseListViewHolder(itemView: View?, val clickListener: ClickListener?) : RecyclerView.ViewHolder(itemView) {
    val textView by lazy {
        itemView?.findViewById(R.id.textview) as TextView
    }

    fun setItemClickListener(position: Int) {
        itemView?.setOnClickListener {
            clickListener?.onClick(position, itemView)
        }

        itemView?.setOnLongClickListener {
            clickListener?.onLongClick(position, itemView)
            true
        }
    }
}