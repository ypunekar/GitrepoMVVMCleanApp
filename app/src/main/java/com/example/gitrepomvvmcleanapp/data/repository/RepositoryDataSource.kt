package com.example.gitrepomvvmcleanapp.data.repository

import android.net.Uri
import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories


interface RepositoryDataSource {

    interface Remote {
        suspend fun getRepositories(): Result<List<Repositories>>
        suspend fun getRepositoriesDetails(user: String,repo:String):Result<RepositoryDetail>
    }
}