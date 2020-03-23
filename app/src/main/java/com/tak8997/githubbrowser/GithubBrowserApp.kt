package com.tak8997.githubbrowser

import android.app.Application
import com.facebook.stetho.Stetho
import com.tak8997.githubbrowser.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class GithubBrowserApp : Application(), HasAndroidInjector {

    companion object {
        lateinit var instance: GithubBrowserApp
            private set
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = activityInjector

    override fun onCreate() {
        super.onCreate()
        instance = this

        setupStetho()
        setupDagger()
    }

    private fun setupStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun setupDagger() {
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }
}