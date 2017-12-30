package com.wsadurski.returntomainscreen

import android.app.Application
import com.wsadurski.returntomainscreen.di.ApplicationComponent
import com.wsadurski.returntomainscreen.di.ApplicationModule
import com.wsadurski.returntomainscreen.di.DaggerApplicationComponent
import com.wsadurski.returntomainscreen.util.ResumedActivityGetterImpl

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

class ReturnToMainScreenApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val resumedActivityGetter = ResumedActivityGetterImpl(this)
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(resumedActivityGetter)).build()
    }

    companion object {
        @JvmStatic lateinit var applicationComponent: ApplicationComponent
    }
}
