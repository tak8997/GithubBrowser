package com.tak8997.githubbrowser.di

import androidx.lifecycle.ViewModelProvider
import com.tak8997.instastylegallery.di.GithubBrowserViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [AppModule.ProvideModule::class])
internal interface AppModule {

    @Module
    class ProvideModule {

    }

    @Binds
    fun bindsViewModelFactory(viewModelFactory: GithubBrowserViewModelFactory): ViewModelProvider.Factory
}
