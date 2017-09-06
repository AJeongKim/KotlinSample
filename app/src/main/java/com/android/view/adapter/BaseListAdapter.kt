package com.android.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.R
import com.android.view.adapter.holder.BaseListViewHolder
import com.android.data.BaseListData
import com.android.listener.ClickListener

class BaseListAdapter : RecyclerView.Adapter<BaseListViewHolder> {
    var context: Context?
    var dataList: ArrayList<BaseListData>
    var clickListener: ClickListener? = null

    // 코틀린엔 클래스마다 init 메서드가 별도 제공
    // 예전 자바에선 constructor에서 초기화를 해줬다면 코틀린에선 init메서드를 생성하여 선언한다.
    init {
        dataList = ArrayList()
    }

    constructor(context: Context, dataList: ArrayList<BaseListData>) {
        this.context = context
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = BaseListViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_base_list_item, parent, false), clickListener)

    override fun onBindViewHolder(holderBase: BaseListViewHolder?, position: Int) {
        var data = dataList.get(position)
        var text = data?.text
        holderBase?.textView?.setText(text)
        holderBase?.itemView?.setTag(text)
        holderBase?.setItemClickListener(position)
    }

    override fun getItemCount() = dataList?.size

    fun removeListItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, dataList.size)
    }
}