package com.example.gitrepomvvmcleanapp.data.repository

import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.data.api.RepositoryApi
import com.example.gitrepomvvmcleanapp.data.mapper.RemoteResponseMapper
import com.example.gitrepomvvmcleanapp.domain.model.Repositories
import java.lang.Exception


class RepositoriesRemoteDataSource(private val repositoryApi: RepositoryApi) : RepositoryDataSource.Remote {
    override suspend fun getRepositories(): Result<List<Repositories>> {
        return try{
            var result = repositoryApi.getRepositories().await()
            com.example.cleanarchpoc.domain.util.Result.Success(RemoteResponseMapper.toDomain(result))
             }
        catch (e: Exception) {
            com.example.cleanarchpoc.domain.util.Result.Error(e)
        }
    }

}