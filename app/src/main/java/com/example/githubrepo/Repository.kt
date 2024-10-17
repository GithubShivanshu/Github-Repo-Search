package com.example.githubrepo

data class Repository(
    val id: Int,
    val name: String,
    val description: String?,
    val owner: Owner,
    val html_url: String
)

data class Owner(
    val avatar_url: String,
    val login: String
)

data class RepoSearchResponse(
    val items: List<Repository>
)