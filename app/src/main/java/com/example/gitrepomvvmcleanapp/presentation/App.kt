package com.example.cleanarchpoc.presentation

import android.app.Application
import com.example.cleanarchpoc.presentation.di.DaggerInjector
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.AppModule
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.DataModule
import com.example.gitrepomvvmcleanapp.presentation.di.core.module.NetworkModule
import com.example.cleanarchpoc.presentation.di.feed.FeedModule
import com.example.gitrepomvvmcleanapp.presentation.di.feed.FeedSubComponent
import com.example.gitrepomvvmcleanapp.presentation.di.core.CoreComponent
import com.example.gitrepomvvmcleanapp.data.util.Constant
import com.example.gitrepomvvmcleanapp.presentation.di.core.DaggerCoreComponent
import com.example.gitrepomvvmcleanapp.presentation.di.detail.DetailModule
import com.example.gitrepomvvmcleanapp.presentation.di.detail.DetailSubComponent


class App : Application(), DaggerInjector {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(Constant.BASE_URL))
                .dataModule(DataModule())
                .build()
    }
    override fun createFeedComponent(): FeedSubComponent {

        return coreComponent.inject(FeedModule())
    }

    override fun createRepositoryDetailComponent(): DetailSubComponent {
        return coreComponent.inject(DetailModule())
    }
}