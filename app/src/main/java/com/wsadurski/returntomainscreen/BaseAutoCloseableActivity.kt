package com.wsadurski.returntomainscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wsadurski.returntomainscreen.useractivity.UserActivityWatcher
import javax.inject.Inject

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

@SuppressLint("Registered")
open class BaseAutoCloseableActivity : AppCompatActivity() {

    @Inject lateinit var userActivityWatcher: UserActivityWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReturnToMainScreenApplication.applicationComponent.inject(this)
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        userActivityWatcher.onUserInteracted()
    }
}
