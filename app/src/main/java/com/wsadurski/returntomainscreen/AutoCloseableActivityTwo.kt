package com.wsadurski.returntomainscreen

import android.content.Intent
import android.os.Bundle
import android.view.View

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

class AutoCloseableActivityTwo : BaseAutoCloseableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
    }

    fun goToActivityThree(v: View) {
        val intent = Intent(this, AutoCloseableActivityThree::class.java)
        startActivity(intent)
    }
}
