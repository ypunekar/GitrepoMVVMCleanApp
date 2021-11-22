package com.example.gitrepomvvmcleanapp.presentation.di.core.module

import android.content.Context
import dagger.Module
import dagger.Provides
import com.aliasadi.clean.presentation.util.DispatchersProvider
import com.aliasadi.clean.presentation.util.DispatchersProviderImpl
import com.example.gitrepomvvmcleanapp.data.util.DiskExecutor
import javax.inject.Singleton



@Module
class AppModule constructor(context: Context) {

    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }

    @Provides
    fun provideDiskExecutor(): DiskExecutor {
        return DiskExecutor()
    }

    @Provides
    fun provideDispatchersProvider(): DispatchersProvider {
        return DispatchersProviderImpl()
    }

}