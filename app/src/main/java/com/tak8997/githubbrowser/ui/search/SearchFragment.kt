package com.tak8997.githubbrowser.ui.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.tak8997.githubbrowser.BaseFragment
import com.tak8997.githubbrowser.R
import com.tak8997.githubbrowser.databinding.FragmentSearchBinding

internal class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    private val repoAdapter by lazy { RepoAdapter(viewModel) }

    override fun getLayoutRes(): Int = R.layout.fragment_search
    override fun getModelClass(): Class<SearchViewModel> = SearchViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.run {
            repos.observe(viewLifecycleOwner) {
                repoAdapter.submitList(it)
            }
        }
    }

    private fun setupView() {
        with(binding.rvRepo) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = repoAdapter
        }
    }
}