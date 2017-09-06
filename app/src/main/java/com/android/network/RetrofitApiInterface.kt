package com.android.network

import com.android.data.FlickrPhotosData
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

/**
 * Created by user on 2017-06-09.
 */
interface RetrofitApiInterface {

    // api_key는 flickr에서 받은 key를 입력하면 된다.
    // 예) ?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=aaaaaa
    @GET("?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=822aa252155b28721ba16c704b2ae273")
    fun getPhotoData(@Query("page") page : Int) : Call<FlickrPhotosData>
}