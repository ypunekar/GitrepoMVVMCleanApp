package com.example.gitrepomvvmcleanapp.domain.repository

import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.Repositories

interface RepositoriesRepository {
    suspend fun getRepository(): Result<List<Repositories>>

}
