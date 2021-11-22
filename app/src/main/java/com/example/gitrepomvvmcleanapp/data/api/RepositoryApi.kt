package com.example.gitrepomvvmcleanapp.data.api

import com.example.example.RemoteRepositoryDetail
import com.example.gitrepomvvmcleanapp.data.model.repositorylist.RepositoryResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryApi {
    @GET("repositories")
    fun getRepositories(): Deferred<List<RepositoryResponse>>

    @GET("repos/{user}/{repo}")
    fun getRepositoryDetails(@Path("user") user: String, @Path("repo") repo: String): Deferred<RemoteRepositoryDetail>
}