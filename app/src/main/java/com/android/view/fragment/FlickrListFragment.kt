package com.android.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.R
import com.android.data.FlickrPhotoData
import com.android.data.FlickrPhotosData
import com.android.network.RetrofitApiInterface
import com.android.network.RetrofitCreator
import com.android.view.adapter.FlickrListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlickrListFragment : Fragment() {
    val recyclerview by lazy {
        view?.findViewById(R.id.flicr_recycler_view) as RecyclerView
    }

    // static instance
    companion object {
        fun getInstance() = FlickrListFragment()
    }

    private var adapter : FlickrListAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_flickr_list, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FlickrListAdapter(activity, ArrayList())
        var layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter
        requestFlickrApi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun requestFlickrApi() {
        val apiInterface : RetrofitApiInterface = RetrofitCreator.createRetrofit()
        val call : Call<FlickrPhotosData> = apiInterface.getPhotoData(1);
        call.enqueue(object : Callback<FlickrPhotosData> {
            override fun onFailure(call: Call<FlickrPhotosData>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<FlickrPhotosData>?, response: Response<FlickrPhotosData>?) {
                val photosData = response?.body()
                val photoPageInfo = photosData?.photos
                val photoDataList = photoPageInfo?.photoList
                adapter?.addItem(photoDataList as ArrayList<FlickrPhotoData>)
                adapter?.notifyDataSetChanged()
            }
        })
    }
}