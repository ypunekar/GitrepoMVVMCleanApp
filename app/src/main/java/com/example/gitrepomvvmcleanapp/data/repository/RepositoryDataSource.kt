package com.example.gitrepomvvmcleanapp.data.repository

import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.Repositories


interface RepositoryDataSource {

    interface Remote {
        suspend fun getRepositories(): Result<List<Repositories>>
    }
}