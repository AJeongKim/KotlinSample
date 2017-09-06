package com.android.data

import com.google.gson.annotations.SerializedName

/**
 * Created by user on 2017-06-09.
 */
class FlickrPhotoData {
    // 어노테이션 : 주석이지만 어떠한 값을 적용시킬 수도 있고
    // 고유클래스를 지칭하는 주석이 될 수도 있다.
    // 굳이 @SerializedName 사용하지 않아도 될 것 같아서 주석처리
    /*@SerializedName("id") var id : String? = ""
    @SerializedName("owner") var owner : String? = ""
    @SerializedName("secret") var secret : String? = ""
    @SerializedName("server") var server : String? = ""
    @SerializedName("farm") var farm : String? = ""
    @SerializedName("title") var title : String? = ""
    @SerializedName("ispublic") var ispublic : Int = 0
    @SerializedName("isfriend") var isfriend : Int = 0
    @SerializedName("isfamily") var isfamily : Int = 0*/

    var id: String? = ""
    var owner : String? = ""
    var secret : String? = ""
    var server : String? = ""
    var farm : String? = ""
    var title : String? = ""
    var ispublic : Int = 0
    var isfriend : Int = 0
    var isfamily : Int = 0

    fun createUrl() : String {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s.jpg", farm, server, id, secret)
    }
}