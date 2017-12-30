package com.wsadurski.returntomainscreen.di

import com.wsadurski.returntomainscreen.useractivity.UserActivityWatcher
import com.wsadurski.returntomainscreen.useractivity.UserActivityWatcherImpl
import com.wsadurski.returntomainscreen.util.ResumedActivityGetter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wojciechsadurski on 19.09.2017.
 */

@Module
class ApplicationModule(private val resumedActivityGetter: ResumedActivityGetter) {

    @Provides
    @Singleton
    fun provideUserActivityWatcher(): UserActivityWatcher {
        return UserActivityWatcherImpl(resumedActivityGetter)
    }
}
