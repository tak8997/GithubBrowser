package com.tak8997.githubbrowser.data.repository

import com.tak8997.githubbrowser.data.apiservice.GitHubApiService
import com.tak8997.githubbrowser.data.model.SearchResponse
import javax.inject.Inject

internal class SearchRepositoryImpl @Inject constructor(
    private val apiService: GitHubApiService
) : SearchRepository {

    override suspend fun searchRepos(): SearchResponse {
        return SearchResponse(0, listOf())
    }
}