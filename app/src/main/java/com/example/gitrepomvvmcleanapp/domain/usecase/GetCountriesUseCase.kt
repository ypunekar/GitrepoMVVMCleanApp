package com.example.cleanarchpoc.domain.usecase

import android.net.Uri
import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
import com.example.gitrepomvvmcleanapp.domain.repository.RepositoriesRepository


open class GetCountriesUseCase( val repositoriesRepository: RepositoriesRepository) {

    suspend fun execute(): Result<List<Repositories>> {
        return repositoriesRepository.getRepository()
    }
    suspend fun executeDetails(user:String,repo:String): Result<RepositoryDetail> {
        return repositoriesRepository.getRepositoryDetail(user,repo)
    }
}
