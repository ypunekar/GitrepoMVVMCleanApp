package com.example.cleanarchpoc.presentation.feed


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import com.example.gitrepomvvmcleanapp.presentation.base.BaseViewModel


class RepositoryListViewModel internal constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,dispatchers: DispatchersProvider)
    : BaseViewModel(dispatchers) {

     val repositoriesMutableState: MutableState<List<Repositories>> = mutableStateOf(ArrayList())
    val repositoriesLivedata: MutableLiveData<List<Repositories>> = MutableLiveData()

    private val showErrorLiveData: MutableLiveData<String> = MutableLiveData()

    fun loadRepositories() {
        getRepositories()    }


     fun getRepositories() {
        execute {
            when (
                val result = getRepositoriesUseCase.execute()) {
                is com.example.cleanarchpoc.domain.util.Result.Success -> {
                   repositoriesMutableState.value=result.data
                    repositoriesLivedata.postValue(result.data)
                    Log.d("project description", result.data[0].description?:"")
                }
                is com.example.cleanarchpoc.domain.util.Result.Error -> {
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }

    fun getRepositoriesResponse():MutableState<List<Repositories>> {
        return repositoriesMutableState;
    }




}