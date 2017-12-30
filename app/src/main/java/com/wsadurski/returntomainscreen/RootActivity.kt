package com.wsadurski.returntomainscreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToActivityOne(v: View) {
        val intent = Intent(this, AutoCloseableActivityOne::class.java)
        startActivity(intent)
    }
}
