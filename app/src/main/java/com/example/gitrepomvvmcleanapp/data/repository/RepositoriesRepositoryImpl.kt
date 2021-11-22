package com.example.gitrepomvvmcleanapp.data.repository

import RepositoryResponse
import android.util.Log
import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.Repositories
import com.example.gitrepomvvmcleanapp.domain.repository.RepositoriesRepository

class RepositoriesRepositoryImpl constructor(
    private val repositoryRemote: RepositoryDataSource.Remote,
) : RepositoriesRepository {

    override suspend fun getRepository(): Result<List<Repositories>> {
        val result = repositoryRemote.getRepositories()
        if (result is Result.Success) {
            Log.d("XXX", "Getting data from remote")}
            //saveCountries(result.data) }
            if (result is Result.Error) {
                //etMoviesFromLocalDataSource()
            }
            return result

    }
}

