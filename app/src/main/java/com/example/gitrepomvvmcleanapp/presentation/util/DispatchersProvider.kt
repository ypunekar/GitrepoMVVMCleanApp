package com.aliasadi.clean.presentation.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {
    fun getIO(): CoroutineDispatcher
    fun getMain(): CoroutineDispatcher
    fun getDefault(): CoroutineDispatcher
}