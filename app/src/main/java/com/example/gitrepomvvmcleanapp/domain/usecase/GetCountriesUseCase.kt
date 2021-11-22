package com.example.cleanarchpoc.domain.usecase

import com.example.cleanarchpoc.domain.util.Result
import com.example.gitrepomvvmcleanapp.domain.model.Repositories
import com.example.gitrepomvvmcleanapp.domain.repository.RepositoriesRepository


open class GetCountriesUseCase( val repositoriesRepository: RepositoriesRepository) {

    suspend fun execute(): Result<List<Repositories>> {
        return repositoriesRepository.getRepository()
    }

}
