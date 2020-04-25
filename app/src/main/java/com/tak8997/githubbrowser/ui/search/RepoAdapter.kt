package com.tak8997.githubbrowser.ui.search

import com.tak8997.githubbrowser.BaseAdapter
import com.tak8997.githubbrowser.R
import com.tak8997.githubbrowser.data.model.Repo

internal class RepoAdapter(viewModel: SearchViewModel): BaseAdapter<Repo>(viewModel) {

    override fun layoutIdByViewType(viewType: Int): Int {
        return R.layout.item_repo
    }
}
