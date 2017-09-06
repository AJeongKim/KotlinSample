package com.android.listener

import android.view.View

interface ClickListener {
    fun onClick(position: Int, view: View)
    fun onLongClick(position: Int, view: View)
}