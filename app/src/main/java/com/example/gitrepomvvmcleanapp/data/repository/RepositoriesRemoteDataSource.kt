package com.example.gitrepomvvmcleanapp.data.repository

import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.data.api.RepositoryApi
import com.example.gitrepomvvmcleanapp.data.mapper.RemoteResponseMapper
import com.example.gitrepomvvmcleanapp.data.mapper.RepositoryDetailMapper
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
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

    override suspend fun getRepositoriesDetails(user: String,repo:String): Result<RepositoryDetail> {
        return try{
            var result = repositoryApi.getRepositoryDetails(user,repo).await()
            com.example.cleanarchpoc.domain.util.Result.Success(RepositoryDetailMapper.toDomain(result))
        }
        catch (e: Exception) {
            com.example.cleanarchpoc.domain.util.Result.Error(e)
        }
    }

}