package com.tak8997.githubbrowser.ui.search

import androidx.lifecycle.ViewModel
import com.tak8997.githubbrowser.di.annotation.FragmentScope
import com.tak8997.githubbrowser.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface SearchModule {

    @Binds
    @FragmentScope
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindsSearchViewModel(viewModel: SearchViewModel): ViewModel
}