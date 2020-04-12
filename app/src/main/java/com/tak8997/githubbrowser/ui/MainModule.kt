package com.tak8997.githubbrowser.ui

import androidx.lifecycle.ViewModel
import com.tak8997.githubbrowser.di.annotation.ActivityScope
import com.tak8997.githubbrowser.di.annotation.FragmentScope
import com.tak8997.githubbrowser.di.annotation.ViewModelKey
import com.tak8997.githubbrowser.ui.favorite.FavoritesModule
import com.tak8997.githubbrowser.ui.search.SearchFragment
import com.tak8997.githubbrowser.ui.search.SearchModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal interface MainModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector(modules = [SearchModule::class])
    @FragmentScope
    fun bindsSearchFragment(): SearchFragment

    @ContributesAndroidInjector(modules = [FavoritesModule::class])
    @FragmentScope
    fun bindsFavoritesModule(): FavoritesModule
}