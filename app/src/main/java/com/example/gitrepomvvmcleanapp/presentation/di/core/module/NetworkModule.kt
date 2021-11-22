package com.example.gitrepomvvmcleanapp.presentation.di.core.module

import com.example.gitrepomvvmcleanapp.data.api.RepositoryApi
import dagger.Module
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
    }

    @Singleton
    @Provides
    fun provideCountriesApi(retrofit: Retrofit): RepositoryApi {
        return retrofit.create(RepositoryApi::class.java)
    }
}