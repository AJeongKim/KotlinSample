package com.android.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.MainActivity
import com.android.R

class BaseFragment : Fragment() {
    private val oneEdit by lazy {
        view?.findViewById(R.id.one_number_edit) as EditText
    }

    private val twoEdit by lazy {
        view?.findViewById(R.id.two_number_edit) as EditText
    }

    private val sumBtn by lazy {
        view?.findViewById(R.id.sum_btn) as Button
    }

    private val sumTxt by lazy {
        view?.findViewById(R.id.sum_txt) as TextView
    }

    // 1. 자바의 static = companion
    // 2. 자바의 final = const val, val
    // 3. const val은 companion object에서 사용가능하고
    // 4. val은 어디서든 사용가능
    companion object {
        fun getInstance() = BaseFragment()

        // 예)
        // const val b: String = ""
        // val a: String = ""

        const val a: String = ""

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_base, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun initView() {
        sumBtn.setOnClickListener {
            sumTxt.setText(getSum().toString())
        }

        oneEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                removeString(oneEdit)
            }
        })

        twoEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                removeString(twoEdit)
            }
        })
    }

    private fun removeString(editText: EditText) {
        try {
            // is는 형비교&형변환, as는 형비교인듯
            // is : 타입검사에서 리턴하면 안전하게 변환할 수 있다는것을 안다.
            // (스마트 변환)
            val oneText = editText?.text?.toString()
            if (oneText?.isNullOrEmpty() as Boolean)
                return;

            oneText?.toInt()
        } catch (e: Exception) {
            if (e is NumberFormatException) {
                Toast.makeText(context, "문자는 안되요", Toast.LENGTH_SHORT).show()
                editText?.setText("")
            }
        }
    }

    private fun getSum(): Int {
        var one = when {
            oneEdit?.text?.isNullOrEmpty() as Boolean -> 0
            else -> oneEdit?.text?.toString()?.toInt()
        }?: 0

        var two = when {
            twoEdit?.text?.isNullOrEmpty() as Boolean -> 0
            else -> twoEdit?.text?.toString()?.toInt()
        }?: 0

        return one + two
    }
}