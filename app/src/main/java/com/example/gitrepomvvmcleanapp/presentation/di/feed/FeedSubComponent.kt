package com.example.cleanarchpoc.presentation.di.feed


import com.example.cleanarchpoc.presentation.feed.FeedActivity
import dagger.Subcomponent

@Subcomponent(modules = [FeedModule::class])
interface FeedSubComponent {
    fun inject(feedActivity: FeedActivity)
}
