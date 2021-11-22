package com.example.gitrepomvvmcleanapp.presentation.di.core

import com.example.gitrepomvvmcleanapp.presentation.di.core.module.AppModule
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.DataModule
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.NetworkModule
import com.example.cleanarchpoc.presentation.di.feed.FeedModule
import com.example.cleanarchpoc.presentation.di.feed.FeedSubComponent
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
}