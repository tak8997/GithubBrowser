package com.tak8997.githubbrowser.ui.favorite

import androidx.lifecycle.ViewModel
import com.tak8997.githubbrowser.di.annotation.FragmentScope
import com.tak8997.githubbrowser.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface FavoritesModule  {

    @Binds
    @FragmentScope
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    fun bindsFavoritesViewModel(viewModel: FavoritesViewModel): ViewModel
}