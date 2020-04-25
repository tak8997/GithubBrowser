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

    fun <T> launchDataLoaded(action: suspend CoroutineScope.() -> Result<T>, onSuccess: (T?) -> Unit): Job {

        return viewModelScope.launch {

            dataLoading.value = true
            action().let {
                when(it) {
                    is Result.Success -> onSuccess(it.data)
                    is Result.Error -> error.value = "error"
                    is Result.NetworkError -> networkError.value = "network error"
                }
                dataLoading.value = false
            }
        }
    }
}