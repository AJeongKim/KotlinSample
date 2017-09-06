package com.android.data

import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017-06-09.
 */
class FlickrPhotosData {
    // 굳이 @SerializedName 사용하지 않아도 될 것 같아서 주석처리
    // @SerializedName("photos") var photos : FlickrPhotosPageData? = FlickrPhotosPageData()

    var photos : FlickrPhotosPageData? = FlickrPhotosPageData()
}