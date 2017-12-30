package com.wsadurski.returntomainscreen.useractivity

import android.content.Intent
import com.wsadurski.returntomainscreen.RootActivity
import com.wsadurski.returntomainscreen.util.ResumedActivityGetter
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Created by wojciechsadurski on 01.09.2017.
 */

class UserActivityWatcherImpl(private val resumedActivityGetter: ResumedActivityGetter) : UserActivityWatcher {

    private var timerDisposable: Disposable? = null

    override fun onUserInteracted() {
        setupTimer()
    }

    private fun setupTimer() {
        timerDisposable?.dispose()
        timerDisposable = Observable.timer(MAX_USER_INACTIVITY_TIME_VALUE, MAX_USER_INACTIVITY_TIME_UNIT).subscribe { aLong ->
            val currentActivityContext = resumedActivityGetter.getResumedActivity()
            if (currentActivityContext != null && currentActivityContext !is RootActivity) {
                val intent = Intent(currentActivityContext, RootActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                currentActivityContext.startActivity(intent)
            }
        }
    }

    companion object {

        private val MAX_USER_INACTIVITY_TIME_VALUE = 3L
        private val MAX_USER_INACTIVITY_TIME_UNIT = TimeUnit.SECONDS
    }
}
