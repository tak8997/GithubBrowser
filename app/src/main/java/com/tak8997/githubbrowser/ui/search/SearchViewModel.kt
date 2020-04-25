package com.tak8997.githubbrowser.ui.search

import androidx.lifecycle.MutableLiveData
import com.tak8997.githubbrowser.BaseViewModel
import com.tak8997.githubbrowser.data.model.Repo
import com.tak8997.githubbrowser.data.model.mapToDomain
import com.tak8997.githubbrowser.data.repository.SearchRepository
import javax.inject.Inject

internal class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
) : BaseViewModel() {

    val repos = MutableLiveData<List<Repo>>()
    val searchCount = MutableLiveData(0)

    fun searchRepos(query: String) {
        launchDataLoaded({
            repository.searchRepos(query)
        }, onSuccess = {
            repos.value = it?.searchResults?.mapToDomain()
            searchCount.value = it?.totalCount
        })
    }
}
