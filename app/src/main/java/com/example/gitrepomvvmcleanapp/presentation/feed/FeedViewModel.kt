package com.example.cleanarchpoc.presentation.feed


import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.cleanarchpoc.domain.usecase.GetCountriesUseCase
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
import com.example.gitrepomvvmcleanapp.presentation.base.BaseViewModel


class FeedViewModel internal constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    dispatchers: DispatchersProvider)
    : BaseViewModel(dispatchers) {

    private val countriesLiveData: MutableState<List<Repositories>> = mutableStateOf(ArrayList())
    val isShowProgressBarLiveData :MutableLiveData<Boolean> = MutableLiveData()
    private val showErrorLiveData: MutableLiveData<String> = MutableLiveData()
    fun loadCountries() {
        getCountris()
    }

    fun loadDetails() {
        getCountris()
    }
    private fun getCountris() {
        isShowProgressBarLiveData.postValue(true)
        execute {
            when (
                val result = getCountriesUseCase.execute()) {
                is com.example.cleanarchpoc.domain.util.Result.Success -> {
                    isShowProgressBarLiveData.postValue(false)
                    countriesLiveData.value=result.data
                    getDetails(result.data[0].username,result.data[0].projectName)
                    Log.d("project description", result.data[0].Description?:"")
                }
                is com.example.cleanarchpoc.domain.util.Result.Error -> {
                    isShowProgressBarLiveData.postValue(false)
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }

    private fun getDetails(user:String,repo:String){
        isShowProgressBarLiveData.postValue(true)
        execute {
            when (val result = getCountriesUseCase.executeDetails(user,repo) ){
                is com.example.cleanarchpoc.domain.util.Result.Success -> {
                    isShowProgressBarLiveData.postValue(false)
                    Log.d("project getDetails", result.data.username)
                }
                is com.example.cleanarchpoc.domain.util.Result.Error -> {
                    isShowProgressBarLiveData.postValue(false)
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }

    fun getCountrisLiveData()= countriesLiveData
    fun getShowErrorLiveData(): LiveData<String> = showErrorLiveData

}