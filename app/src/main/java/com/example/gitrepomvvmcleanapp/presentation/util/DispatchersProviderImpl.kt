package com.example.gitrepomvvmcleanapp.presentation.util

import com.aliasadi.clean.presentation.util.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher
class DispatchersProviderImpl : DispatchersProvider {

    override fun getMain(): MainCoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun getIO(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun getDefault(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}