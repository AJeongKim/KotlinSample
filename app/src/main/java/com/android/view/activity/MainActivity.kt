package com.android

import android.content.Context
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.android.listener.ClickListener
import com.android.view.fragment.BaseFragment
import com.android.view.fragment.ImageLoaderLibraryFragment
import com.android.view.fragment.BaseListFragment
import com.android.view.fragment.FlickrListFragment

// *******************클래스*****************************
// 1. 헤더와 몸체는 필수가 아니다. (자바는 필수)
// 2. 몸체는 생략가능 하지만 헤더는 생략할 수 없다.
// 3. 클래스는 한개의 주요 생성자와 한개 이상의 보조 생성자를 가질 수 있다.
class MainActivity : AppCompatActivity() {
    // *******************프로퍼티***************************
    // 1. 코틀린은 프로퍼티로 변수를 선언한다. (프로퍼티=멤버변수)
    // 2. 상수 val, 변수 var
    // 3. 프로퍼티를 선언할 때 getter, setter가 포함되어 있다.
    // 4. 프로퍼티의 기본 getter, setter는 따로 정의하지 않아도 된다.
    // 5. 프로퍼티 선언 후 getter, setter을 커스텀해서 사용할 수도 있다.
    // 예)
    // private var a: Int = 0
    //     set(value) {if(value > 10) field = value}
    //     get() {return a}
    // var text: String? = null
    //     set(receiveText) {if (field.equals("test")) field = receiveText}
    //     get() {if (field == null || field.equals("")) return "empty"; return field}

    // *******************연산자*****************************
    // 1. 코틀린 타입 시스템은 코드에서 NullPointerException을 제거하려고 노력했다.
    // 2. null error가 필요하다면 ?대신 !!을 쓰면된다.
    // 3. ?는 null이면 자동적으로 throw시킴. null인지 아닌지 알 수 없을 수도 있다.
    // 4. 엘비스 연산자 ?:는 null인지 non-null인지 구별하는 if문을 간결하게 나타낼 수 있다.
    // 5. var text: String? = "abc"
    // 6. var length = text?.length ?: -1

    private var imm: InputMethodManager? = null

    private val toolbar by lazy {
        findViewById(R.id.toolbar) as Toolbar
    }

    private val drawerLayout by lazy {
        findViewById(R.id.drawer_layout) as DrawerLayout
    }

    private val navigationView by lazy {
        findViewById(R.id.navigation_view) as NavigationView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        setSupportActionBar(toolbar)

        var toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        drawerLayout.setDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.menu_base ->
                    BaseFragment.getInstance()
                R.id.menu_recyclerview ->
                    BaseListFragment.getInstance()
                R.id.menu_retrofit ->
                    FlickrListFragment.getInstance()
//                R.id.menu_image_loader_library ->
//                    ImageLoaderLibraryFragment.getInstance()
                else -> BaseFragment.getInstance()
            }
            setFragment(fragment)
            drawerLayout.closeDrawers()

            true
        }

        setFragment(BaseFragment.getInstance())
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        hideSoftKeyboard()
        super.onDestroy()
    }

    override fun onBackPressed() {
        hideSoftKeyboard()
        super.onBackPressed()
    }

    private fun hideSoftKeyboard() {
        //
        imm!!.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_layout, fragment)
        transaction.commit()
    }
}
