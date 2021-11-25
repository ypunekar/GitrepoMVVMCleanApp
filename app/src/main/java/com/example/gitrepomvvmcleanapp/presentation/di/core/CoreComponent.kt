package com.example.gitrepomvvmcleanapp.presentation.di.core

import com.example.gitrepomvvmcleanapp.presentation.di.core.module.AppModule
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.DataModule
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.NetworkModule
import com.example.cleanarchpoc.presentation.di.feed.FeedModule
import com.example.gitrepomvvmcleanapp.presentation.di.feed.FeedSubComponent
import com.example.gitrepomvvmcleanapp.presentation.di.detail.DetailModule
import com.example.gitrepomvvmcleanapp.presentation.di.detail.DetailSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DataModule::class
])

interface CoreComponent {
    fun inject(feedModule: FeedModule): FeedSubComponent
    fun inject(repositoryDetail: DetailModule): DetailSubComponent
}