package com.tak8997.githubbrowser.di

import com.tak8997.githubbrowser.di.annotation.ActivityScope
import com.tak8997.githubbrowser.ui.MainActivity
import com.tak8997.githubbrowser.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @ActivityScope
    abstract fun mainActivity(): MainActivity
}
