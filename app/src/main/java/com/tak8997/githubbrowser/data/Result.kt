package com.tak8997.githubbrowser.data

sealed class Result<out T> {

    data class Success<out T>(val data: T?): Result<T>()
    data class Error(val exception: Exception?): Result<Nothing>()
    object NetworkError: Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is NetworkError -> ""
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null