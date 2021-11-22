package com.example.cleanarchpoc.presentation.di.feed

import dagger.Module
import dagger.Provides
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.cleanarchpoc.domain.usecase.GetCountriesUseCase
import com.example.cleanarchpoc.presentation.feed.FeedViewModelFactory


@Module
class FeedModule {
    @Provides
    fun provideFeedViewModelFactory(getCountriesUse: GetCountriesUseCase, dispatchersProvider: DispatchersProvider): FeedViewModelFactory {
        return FeedViewModelFactory(getCountriesUse, dispatchersProvider)
    }

}