package com.tak8997.githubbrowser.ui.search

import androidx.lifecycle.MutableLiveData
import com.tak8997.githubbrowser.BaseViewModel
import com.tak8997.githubbrowser.data.repository.SearchRepository
import javax.inject.Inject

internal class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
) : BaseViewModel() {

    val searchCount = MutableLiveData<String>()
}
