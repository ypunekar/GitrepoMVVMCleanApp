package com.example.gitrepomvvmcleanapp.presentation.base


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import com.aliasadi.clean.presentation.util.DispatchersProvider
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(var dispatchers:DispatchersProvider
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = dispatchers.getMain() + SupervisorJob()

    fun execute(job: suspend () -> Unit) = launch {
        withContext(dispatchers.getIO()) { job() }
    }

}