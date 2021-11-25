package com.example.gitrepomvvmcleanapp.presentation.di.detail

import dagger.Module
import dagger.Provides
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.cleanarchpoc.presentation.feed.RepositoryDetailViewModelFactory
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase


@Module
class DetailModule {
    @Provides
    fun provideFeedViewModelFactory(getCountriesUse: GetRepositoriesUseCase, dispatchersProvider: DispatchersProvider): RepositoryDetailViewModelFactory {
        return RepositoryDetailViewModelFactory(getCountriesUse, dispatchersProvider)
    }

}