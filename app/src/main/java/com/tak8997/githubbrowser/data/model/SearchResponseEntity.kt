package com.tak8997.githubbrowser.data.model

import com.google.gson.annotations.SerializedName
import com.tak8997.githubbrowser.base.BaseItem

internal data class SearchResponseEntity(
    @field:SerializedName("total_count")
    val totalCount: Int,
    @field:SerializedName("items")
    val searchResults: List<SearchEntity>
)

internal data class SearchEntity(
    val id: Int,
    @field:SerializedName("name")
    val repoName: String,
    @field:SerializedName("full_name")
    val fullName: String,
    val owner: OwnerEntity,
    val private: Boolean,
    val description: String?,
    @field:SerializedName("updated_at")
    val updatedAt: String,
    val size: Int,
    @field:SerializedName("stargazers_count")
    val stargazersCount: Int,
    val language: String,
    @field:SerializedName("has_wiki")
    val hasWiki: Boolean,
    val archived: Boolean,
    val score: Double
)

internal data class OwnerEntity(
    @field:SerializedName("login")
    val login: String,
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("avatar_url")
    val avatarImgUrl: String,
    @field:SerializedName("url")
    val onwerUrl: String,
    @field:SerializedName("type")
    val type: String
)

internal data class SearchResponse(
    val totalCount: Int,
    val searchResults: List<Repo>
)

internal data class Repo(
    val id: Int,
    val repoName: String,
    val fullName: String,
    val description: String? = "",
    val stargazersCount: Int
) : BaseItem(id)

internal fun SearchResponseEntity.mapToDomain(): SearchResponse
        = SearchResponse(totalCount, searchResults.mapToDomain())

internal fun List<SearchEntity>.mapToDomain(): List<Repo> = map { it.mapToDomain() }

internal fun SearchEntity.mapToDomain(): Repo
        = Repo(id, repoName, fullName, description, stargazersCount)
//{
//    "total_count": 40,
//    "incomplete_results": false,
//    "items": [
//    {
//        "id": 3081286,
//        "node_id": "MDEwOlJlcG9zaXRvcnkzMDgxMjg2",
//        "name": "Tetris",
//        "full_name": "dtrupenn/Tetris",
//        "owner": {
    //        "login": "dtrupenn",
    //        "id": 872147,
    //        "node_id": "MDQ6VXNlcjg3MjE0Nw==",
    //        "avatar_url": "https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
    //        "gravatar_id": "",
    //        "url": "https://api.github.com/users/dtrupenn",
    //        "received_events_url": "https://api.github.com/users/dtrupenn/received_events",
    //        "type": "User"
    //    },
//        "private": false,
//        "html_url": "https://github.com/dtrupenn/Tetris",
//        "description": "A C implementation of Tetris using Pennsim through LC4",
//        "fork": false,
//        "url": "https://api.github.com/repos/dtrupenn/Tetris",
//        "created_at": "2012-01-01T00:31:50Z",
//        "updated_at": "2013-01-05T17:58:47Z",
//        "pushed_at": "2012-01-01T00:37:02Z",
//        "homepage": "",
//        "size": 524,
//        "stargazers_count": 1,
//        "watchers_count": 1,
//        "language": "Assembly",
//        "forks_count": 0,
//        "open_issues_count": 0,
//        "master_branch": "master",
//        "default_branch": "master",
//        "score": 1.0
//    }
//    ]
//}