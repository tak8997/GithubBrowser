package com.tak8997.githubbrowser.data.apiservice

import com.tak8997.githubbrowser.data.Result
import com.tak8997.githubbrowser.data.model.SearchResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GitHubApiService {

    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String): Result<SearchResponseEntity>
}