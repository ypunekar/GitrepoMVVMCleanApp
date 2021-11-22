package com.example.gitrepomvvmcleanapp.domain.repository

import android.net.Uri
import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories

interface RepositoriesRepository {
    suspend fun getRepository(): Result<List<Repositories>>
    suspend fun getRepositoryDetail(user: String,repo:String): Result<RepositoryDetail>

}
