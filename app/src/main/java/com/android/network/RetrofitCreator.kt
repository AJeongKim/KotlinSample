package com.android.network

import retrofit2.GsonConverterFactory
import retrofit2.Retrofit

/**
 * Created by user on 2017-06-09.
 */
class RetrofitCreator {

    companion object {
        fun createRetrofit() : RetrofitApiInterface {
            val retrofit : Retrofit = Retrofit.Builder()
                    .baseUrl("https://api.flickr.com/services/rest/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(RetrofitApiInterface::class.java)
        }
    }
}