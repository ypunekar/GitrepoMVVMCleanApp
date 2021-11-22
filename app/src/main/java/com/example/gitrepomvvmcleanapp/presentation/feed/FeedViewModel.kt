package com.example.cleanarchpoc.presentation.feed


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.cleanarchpoc.domain.usecase.GetCountriesUseCase
import com.example.gitrepomvvmcleanapp.domain.model.Repositories
import com.example.gitrepomvvmcleanapp.presentation.base.BaseViewModel


class FeedViewModel internal constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    dispatchers: DispatchersProvider)
    : BaseViewModel(dispatchers) {

    private val countriesLiveData: MutableLiveData<List<Repositories>> = MutableLiveData()
    val isShowProgressBarLiveData :MutableLiveData<Boolean> = MutableLiveData()
    private val showErrorLiveData: MutableLiveData<String> = MutableLiveData()

    fun loadCountries() {
        getCountris()
    }

    private fun getCountris() {
        isShowProgressBarLiveData.postValue(true)
        execute {
            when (
                val result = getCountriesUseCase.execute()) {
                is com.example.cleanarchpoc.domain.util.Result.Success -> {
                    isShowProgressBarLiveData.postValue(false)
                    countriesLiveData.postValue(result.data)
                    Log.d("project description", result.data[0].Description?:"")
                }
                is com.example.cleanarchpoc.domain.util.Result.Error -> {
                    isShowProgressBarLiveData.postValue(false)
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }


    fun getCountrisLiveData(): LiveData<List<Repositories>> = countriesLiveData
    fun getShowErrorLiveData(): LiveData<String> = showErrorLiveData

}