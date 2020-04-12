package com.tak8997.githubbrowser.data.model

data class SearchResponse(
    val totalCount: Int,
    val searchResults: List<SearchResult>
)