package com.android

import android.app.Activity
import android.os.Bundle

/**
 * Created by user on 2017-08-08.
 */
private fun testMethod() {

}

public fun testMethod2() {

}

public fun testMethod3() {

}

internal fun testMethod4() {

}

class KotlinActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        testMethod()
    }

    public fun testMethod3() {
    }
}