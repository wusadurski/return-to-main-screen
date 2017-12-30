package com.wsadurski.returntomainscreen

import android.content.Intent
import android.os.Bundle
import android.view.View

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

class AutoCloseableActivityThree : BaseAutoCloseableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
    }

    fun goToRootActivity(v: View) {
        val intent = Intent(this, RootActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}
