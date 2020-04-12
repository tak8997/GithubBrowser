package com.tak8997.githubbrowser.data.repository

import com.tak8997.githubbrowser.data.model.SearchResponse

internal interface SearchRepository {

    suspend fun searchRepos(): SearchResponse
}