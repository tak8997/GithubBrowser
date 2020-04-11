package com.tak8997.githubbrowser.ui.search

import androidx.lifecycle.MutableLiveData
import com.tak8997.githubbrowser.BaseViewModel

internal class SearchViewModel : BaseViewModel() {

    val searchCount = MutableLiveData<String>()
}
