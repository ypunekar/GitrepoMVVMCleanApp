package com.example.gitrepomvvmcleanapp.presentation.di.detail


import com.example.gitrepomvvmcleanapp.presentation.detail.RepositoryDetailActivity
import dagger.Subcomponent

@Subcomponent(modules = [DetailModule::class])
interface DetailSubComponent {
    fun inject(detailActivity: RepositoryDetailActivity)
}
