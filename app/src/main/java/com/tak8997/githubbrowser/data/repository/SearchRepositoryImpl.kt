package com.tak8997.githubbrowser.data.repository

import com.tak8997.githubbrowser.data.Result
import com.tak8997.githubbrowser.data.apiservice.GitHubApiService
import com.tak8997.githubbrowser.data.model.SearchResponseEntity
import javax.inject.Inject

internal class SearchRepositoryImpl @Inject constructor(
    private val apiService: GitHubApiService
) : SearchRepository {

    override suspend fun searchRepos(query: String): Result<SearchResponseEntity> {
        return apiService.searchRepos(query)
    }
}