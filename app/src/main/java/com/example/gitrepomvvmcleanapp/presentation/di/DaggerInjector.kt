package com.example.cleanarchpoc.presentation.di

import com.example.cleanarchpoc.presentation.di.feed.FeedSubComponent

interface DaggerInjector {
    fun createFeedComponent(): FeedSubComponent
}