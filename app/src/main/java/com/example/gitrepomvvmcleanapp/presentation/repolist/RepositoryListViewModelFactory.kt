package com.example.gitrepomvvmcleanapp.presentation.repolist


import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.cleanarchpoc.presentation.feed.RepositoryListViewModel
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase


class RepositoryListViewModelFactory(
    private val getRepositoriesUseCase: GetRepositoriesUseCase, var dispatcher:DispatchersProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepositoryListViewModel(getRepositoriesUseCase,dispatcher) as T
    }

}