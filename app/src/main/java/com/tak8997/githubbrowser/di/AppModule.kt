package com.tak8997.githubbrowser.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.tak8997.githubbrowser.GithubBrowserApp
import com.tak8997.githubbrowser.data.repository.SearchRepository
import com.tak8997.githubbrowser.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule.ProvideModule::class])
internal interface AppModule {

    @Module
    class ProvideModule {

        @Singleton
        @Provides
        fun provideContext(): Context = GithubBrowserApp.instance
    }

    @Binds
    @Singleton
    fun bindsSearchRepository(repository: SearchRepositoryImpl): SearchRepository

    @Binds
    fun bindsViewModelFactory(viewModelFactory: GithubBrowserViewModelFactory): ViewModelProvider.Factory
}
