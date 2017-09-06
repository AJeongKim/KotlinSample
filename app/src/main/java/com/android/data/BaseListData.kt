package com.android.data

data class BaseListData(var text: String)

// *******************클래스******************************
// 1. 일반적인 클래스로 만들었을 경우, 위와 같음
// class Sample() {
//    var a: Int = 0
//    var b: Int = 0
//    var c: Int = 0
// }
// 2. extends나 implements 모두 :로 사용. 그냥 콤마,로 구분
// 예) class MainActivity : AppCompatActivity(), ClickListener
// 3. 클래스 생성할 때 생성자 클래스 바디에 바로 생성 가능
// 예) class TestClass constructor(val context: Context, val default: Int) {}
// 예) class TestClass(val context: Context, val default: Int) {}
//
// 4. open, const, val