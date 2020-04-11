package com.tak8997.githubbrowser.ui.search

import android.os.Bundle
import android.view.View
import com.tak8997.githubbrowser.BaseFragment
import com.tak8997.githubbrowser.R
import com.tak8997.githubbrowser.databinding.FragmentSearchBinding

internal class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_search
    override fun getModelClass(): Class<SearchViewModel> = SearchViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}