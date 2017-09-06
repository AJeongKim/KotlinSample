package com.android.data

import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017-06-09.
 */
class FlickrPhotosPageData {
    // 굳이 @SerializedName 사용하지 않아도 될 것 같아서 주석처리
    /*@SerializedName("page") var page : Int = 0
    @SerializedName("pages") var pages : Int = 0
    @SerializedName("perpage") var perpage : Int = 0
    @SerializedName("total") var total : Int = 0
    @SerializedName("photo") var photoList : ArrayList<FlickrPhotoData>? = ArrayList()*/

    var page : Int = 0
    var pages : Int = 0
    var perpage : Int = 0
    var total : Int = 0
    var photoList : ArrayList<FlickrPhotoData>? = ArrayList()
}