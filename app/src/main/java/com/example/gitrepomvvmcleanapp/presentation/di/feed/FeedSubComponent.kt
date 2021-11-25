package com.example.gitrepomvvmcleanapp.presentation.di.feed


import com.example.cleanarchpoc.presentation.di.feed.FeedModule
import com.example.gitrepomvvmcleanapp.presentation.repolist.RepositoryListActivity
import dagger.Subcomponent

@Subcomponent(modules = [FeedModule::class])
interface FeedSubComponent {
    fun inject(repositoryListActivity: RepositoryListActivity)

}
