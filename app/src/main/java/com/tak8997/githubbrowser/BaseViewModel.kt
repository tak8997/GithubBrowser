package com.tak8997.githubbrowser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tak8997.githubbrowser.data.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val dataLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    val networkError = MutableLiveData<String>()

    fun <T> launchDataLoaded(action: suspend CoroutineScope.() -> Result<T>): T? {

        var result: T? = null

        viewModelScope.launch {

            dataLoading.value = true
            action().let {
                result = when(it) {
                    is Result.Success -> it.data
                    is Result.Error -> {
                        error.value = "error"
                        null
                    }
                    is Result.NetworkError -> {
                        networkError.value = "network error"
                        null
                    }
                }
                dataLoading.value = false
            }
        }

        return result
    }
}