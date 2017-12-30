package com.wsadurski.returntomainscreen.util

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

class ResumedActivityGetterImpl(application: Application) : ResumedActivityGetter, Application.ActivityLifecycleCallbacks {

    private var lastResumedActivity: Activity? = null
    private var runningActivitiesNumber: Int = 0

    init {
        application.registerActivityLifecycleCallbacks(this)
    }

    override fun getResumedActivity(): Activity? {
        return lastResumedActivity
    }

    override fun onActivityCreated(
            activity: Activity,
            bundle: Bundle?
    ) {
        runningActivitiesNumber++
    }

    override fun onActivityStarted(activity: Activity) {
        //do nothing
    }

    override fun onActivityResumed(activity: Activity) {
        lastResumedActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {
        //do nothing
    }

    override fun onActivityStopped(activity: Activity) {
        //do nothing
    }

    override fun onActivitySaveInstanceState(
            activity: Activity,
            bundle: Bundle
    ) {
        //do nothing
    }

    override fun onActivityDestroyed(activity: Activity) {
        runningActivitiesNumber--
        if (runningActivitiesNumber == 0) {
            lastResumedActivity = null
        }
    }
}
