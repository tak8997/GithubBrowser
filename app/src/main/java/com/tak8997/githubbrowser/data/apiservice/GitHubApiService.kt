package com.tak8997.githubbrowser.data.apiservice

import com.tak8997.githubbrowser.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

internal interface GitHubApiService {

    @Headers("Accept: application/vnd.github.mercy-preview+json")
    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): SearchResponse
}