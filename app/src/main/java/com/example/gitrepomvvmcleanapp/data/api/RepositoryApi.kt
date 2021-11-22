package com.example.gitrepomvvmcleanapp.data.api

import RepositoryResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RepositoryApi {
    @GET("repositories")
    fun getRepositories(): Deferred<List<RepositoryResponse>>
}