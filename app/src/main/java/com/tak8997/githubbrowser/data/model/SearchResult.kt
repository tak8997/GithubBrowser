package com.tak8997.githubbrowser.data.model

class SearchResult(
    val id: Int,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val description: String,
    val updatedAt: String,
    val size: Int,
    val stargazersCount: Int,
    val language: String,
    val hasWiki: Boolean,
    val archived: Boolean,
    val score: Double
)