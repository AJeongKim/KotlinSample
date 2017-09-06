package com.android.view.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.R
import com.android.view.adapter.BaseListAdapter
import com.android.data.BaseListData
import com.android.listener.ClickListener

class BaseListFragment : Fragment() {
    private val recyclerview by lazy {
        view?.findViewById(R.id.base_recycler_view) as RecyclerView
    }

    // static instance
    companion object {
        fun getInstance() = BaseListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_base_list, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var dataList: ArrayList<BaseListData> = ArrayList()
        for (i in 1..20) {
            var data = BaseListData("data $i")
            dataList.add(data)
        }

        val dividerItemDecoration = DividerItemDecoration(activity, LinearLayoutManager(activity).orientation)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapterBase = BaseListAdapter(activity, dataList)
        adapterBase?.clickListener = object : ClickListener {
            override fun onClick(position: Int, view: View) {
                Toast.makeText(activity, "${view.tag}를 클릭했네요", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(position: Int, view: View) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setTitle("${view.tag} 삭제 할까요?")
                dialogBuilder.setPositiveButton("확인", DialogInterface.OnClickListener {
                    dialog, which ->
                    adapterBase.removeListItem(position)
                    dialog.dismiss()
                })
                dialogBuilder.setNegativeButton("취소", DialogInterface.OnClickListener {
                    dialog, which ->
                    dialog.dismiss()
                })
                dialogBuilder.create()
                dialogBuilder.show()
            }

        }

        recyclerview.addItemDecoration(dividerItemDecoration)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapterBase
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    // *******************람다식******************************
    // 1. 이름없는 익명함수
    // 2. 고차함수는 다른 함수를 인자로 받거나 그 결과로 함수를 반환하는 함수를 말한다. (=콜백함수)
    // 3. 람다식에선 리턴 타입을 지정해주지 않아도 자동적으로 유추한다.
    // 4. 람다식 구문을 사용할 때 return 타입을 자동으로 유추해서 지정해주지만, 명시적으로 지정하고
    //    싶다면 임의함수 구문을 사용할 수 있다.
    // 5. 람다식 안에서 return을 사용하면 둘러싼 함수에서 return, 임의 함수 안에서 return하면 임의함수 자체에서 return.
    // 6. 클로저 : 람다식이나 임의함수는 외부 범위에 선언한 변수(멤버변수)에 접근할 수 있다.
    //    자바와 달리 클로저로 캡처한 변수를 수정할 수 있다.
}