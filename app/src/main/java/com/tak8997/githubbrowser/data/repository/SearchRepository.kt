package com.tak8997.githubbrowser.data.repository

import com.tak8997.githubbrowser.data.Result
import com.tak8997.githubbrowser.data.model.SearchResponseEntity

internal interface SearchRepository {

    suspend fun searchRepos(query: String): Result<SearchResponseEntity>
}