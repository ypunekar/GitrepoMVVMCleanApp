package com.example.gitrepomvvmcleanapp.presentation.di.core.module


import com.example.gitrepomvvmcleanapp.data.api.RepositoryApi
import com.example.gitrepomvvmcleanapp.data.repository.RepositoriesRemoteDataSource
import com.example.gitrepomvvmcleanapp.data.repository.RepositoriesRepositoryImpl
import com.example.gitrepomvvmcleanapp.data.repository.RepositoryDataSource
import com.example.gitrepomvvmcleanapp.domain.repository.RepositoriesRepository
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRepositoriesRemoteRepository(repositoriesRemote: RepositoryDataSource.Remote
                            ): RepositoriesRepository {
        return RepositoriesRepositoryImpl(repositoriesRemote)
    }
    @Provides
    @Singleton
    fun provideUserString() :String {
        return String()
    }
    @Provides
    @Singleton
    fun provideRepositoriesRemoteDataSource(repositoriesApi: RepositoryApi): RepositoryDataSource.Remote {
        return RepositoriesRemoteDataSource(repositoriesApi)
    }

    @Provides
    fun provideRepositoriesUseCase(repositoriesRepository: RepositoriesRepository): GetRepositoriesUseCase {
        return GetRepositoriesUseCase(repositoriesRepository)
    }

}