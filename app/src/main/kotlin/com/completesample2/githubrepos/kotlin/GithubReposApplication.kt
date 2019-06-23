package com.completesample2.githubrepos.kotlin

import android.app.Application
import com.completesample2.githubrepos.BuildConfig
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import timber.log.Timber

/**
 *
 * GithubReposApplication is the project application class.
 */

class GithubReposApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}