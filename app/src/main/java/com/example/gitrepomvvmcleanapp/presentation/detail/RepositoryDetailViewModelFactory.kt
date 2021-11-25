package com.example.cleanarchpoc.presentation.feed


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import com.example.gitrepomvvmcleanapp.presentation.detail.RepositoryDetailViewModel


class RepositoryDetailViewModelFactory(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,
    private val dispatchers: DispatchersProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepositoryDetailViewModel(getRepositoriesUseCase, dispatchers) as T
    }

}