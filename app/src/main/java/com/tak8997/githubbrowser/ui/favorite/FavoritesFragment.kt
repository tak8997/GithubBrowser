package com.tak8997.githubbrowser.ui.favorite

import android.os.Bundle
import android.view.View
import com.tak8997.githubbrowser.BaseFragment
import com.tak8997.githubbrowser.R
import com.tak8997.githubbrowser.databinding.FragmentFavoritesBinding

internal class FavoritesFragment : BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_favorites
    override fun getModelClass(): Class<FavoritesViewModel> = FavoritesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}