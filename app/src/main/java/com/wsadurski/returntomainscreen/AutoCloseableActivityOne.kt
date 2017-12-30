package com.wsadurski.returntomainscreen

import android.content.Intent
import android.os.Bundle
import android.view.View

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

class AutoCloseableActivityOne : BaseAutoCloseableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
    }

    fun goToActivityTwo(v: View) {
        val intent = Intent(this, AutoCloseableActivityTwo::class.java)
        startActivity(intent)
    }
}
