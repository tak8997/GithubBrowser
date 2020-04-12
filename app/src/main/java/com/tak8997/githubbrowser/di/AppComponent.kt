package com.tak8997.githubbrowser.di

import android.content.Context
import com.tak8997.githubbrowser.GithubBrowserApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    NetworkModule::class,
    AppModule::class
])
internal interface AppComponent : AndroidInjector<GithubBrowserApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}
