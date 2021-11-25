package com.example.cleanarchpoc.presentation.di

import com.example.gitrepomvvmcleanapp.presentation.di.feed.FeedSubComponent
import com.example.gitrepomvvmcleanapp.presentation.di.detail.DetailSubComponent

interface DaggerInjector {
    fun createFeedComponent(): FeedSubComponent
    fun createRepositoryDetailComponent(): DetailSubComponent

}