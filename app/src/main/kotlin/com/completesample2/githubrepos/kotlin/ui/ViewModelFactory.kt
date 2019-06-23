package com.completesample2.githubrepos.kotlin.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.completesample2.githubrepos.kotlin.data.GithubRepository
import com.completesample2.githubrepos.kotlin.ui.reboslist.GithubReposListViewModel
import com.completesample2.githubrepos.kotlin.ui.repodetails.RepoDetailsViewModel

/**
 *
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GithubReposListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GithubReposListViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(RepoDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RepoDetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
