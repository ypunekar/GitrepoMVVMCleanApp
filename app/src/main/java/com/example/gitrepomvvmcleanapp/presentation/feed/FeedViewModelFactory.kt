package com.example.cleanarchpoc.presentation.feed


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.cleanarchpoc.domain.usecase.GetCountriesUseCase


class FeedViewModelFactory(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val dispatchers: DispatchersProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeedViewModel(getCountriesUseCase, dispatchers) as T
    }

}