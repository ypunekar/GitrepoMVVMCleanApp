package com.example.gitrepomvvmcleanapp.presentation.di.core.module


import com.example.cleanarchpoc.domain.usecase.GetCountriesUseCase
import com.example.gitrepomvvmcleanapp.data.api.RepositoryApi
import com.example.gitrepomvvmcleanapp.data.repository.RepositoriesRemoteDataSource
import com.example.gitrepomvvmcleanapp.data.repository.RepositoriesRepositoryImpl
import com.example.gitrepomvvmcleanapp.data.repository.RepositoryDataSource
import com.example.gitrepomvvmcleanapp.domain.repository.RepositoriesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideCountriesRepository(countriesRemote: RepositoryDataSource.Remote
                            ): RepositoriesRepository {
        return RepositoriesRepositoryImpl(countriesRemote)
    }

    @Provides
    @Singleton
    fun provideCountriesRemoteDataSource(countriesApi: RepositoryApi): RepositoryDataSource.Remote {
        return RepositoriesRemoteDataSource(countriesApi)
    }

    @Provides
    fun provideGetCountriesUseCase(countriesRepository: RepositoriesRepository): GetCountriesUseCase {
        return GetCountriesUseCase(countriesRepository)
    }

}