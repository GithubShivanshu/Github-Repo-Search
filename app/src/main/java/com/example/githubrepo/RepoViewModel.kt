package com.example.githubrepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepo.model.Repository
import com.example.githubrepo.repository.RepoRepository
import kotlinx.coroutines.launch

class RepoViewModel(private val repository: RepoRepository) : ViewModel() {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> get() = _repositories

    fun searchRepositories(query: String, page: Int) {
        viewModelScope.launch {
            val response = repository.searchRepositories(query, page)
            if (response.isSuccessful) {
                _repositories.value = response.body()?.items ?: emptyList()
            }
        }
    }
}