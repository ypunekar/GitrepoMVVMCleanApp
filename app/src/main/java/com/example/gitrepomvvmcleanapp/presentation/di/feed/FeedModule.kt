package com.example.cleanarchpoc.presentation.di.feed

import dagger.Module
import dagger.Provides
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import com.example.gitrepomvvmcleanapp.presentation.repolist.RepositoryListViewModelFactory


@Module
class FeedModule {
    @Provides
    fun provideFeedViewModelFactory(getRepositoriesUseCase: GetRepositoriesUseCase, dispatchersProvider: DispatchersProvider): RepositoryListViewModelFactory {
        return RepositoryListViewModelFactory(getRepositoriesUseCase, dispatchersProvider)
    }

}