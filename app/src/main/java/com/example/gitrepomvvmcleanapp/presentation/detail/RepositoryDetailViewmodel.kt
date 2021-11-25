package com.example.gitrepomvvmcleanapp.presentation.detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import com.example.gitrepomvvmcleanapp.presentation.base.BaseViewModel

class RepositoryDetailViewModel constructor(
    private val getRepositoriesUseCase: GetRepositoriesUseCase,
    dispatchers: DispatchersProvider
) : BaseViewModel(dispatchers) {
    val repositoryDetail: MutableState<RepositoryDetail?> = mutableStateOf(null)

    fun getDetails(user:String,repo:String){
        execute {
            when (val result = getRepositoriesUseCase.executeDetails(user,repo) ){
                is com.example.cleanarchpoc.domain.util.Result.Success -> {
                    repositoryDetail.value= result.data
                    Log.d("project getDetails", result.data.username)
                }
                is com.example.cleanarchpoc.domain.util.Result.Error -> {

                }
            }
        }
    }
}