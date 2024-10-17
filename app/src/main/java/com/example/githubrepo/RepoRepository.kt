package com.example.githubrepo

import com.example.githubrepo.api.GitHubApiService
import com.example.githubrepo.model.Contributor
import com.example.githubrepo.model.RepoSearchResponse
import retrofit2.Response

class RepoRepository(private val apiService: GitHubApiService) {

    suspend fun searchRepositories(query: String, page: Int): Response<RepoSearchResponse> {
        return apiService.searchRepositories(query, page)
    }

    suspend fun getContributors(owner: String, repo: String): Response<List<Contributor>> {
        return apiService.getContributors(owner, repo)
    }
}