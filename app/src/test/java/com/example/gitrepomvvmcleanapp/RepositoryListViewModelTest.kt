package com.example.gitrepomvvmcleanapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.getValue
import androidx.lifecycle.Observer
import com.example.cleanarchpoc.domain.util.Result
import com.example.cleanarchpoc.presentation.feed.RepositoryListViewModel
import com.example.gitrepomvvmcleanapp.data.repository.RepositoryDataSource
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner



@RunWith(MockitoJUnitRunner::class)
class RepositoryListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    fun <T> any(): T = Mockito.any<T>()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    inline fun <reified T> mock(): T = Mockito.mock(T::class.java)


    @Mock
    lateinit var getRepositoriesUseCase:GetRepositoriesUseCase

    lateinit var repositoryListViewModel: RepositoryListViewModel

    @Before
    fun setUp() {
        repositoryListViewModel = RepositoryListViewModel(getRepositoriesUseCase,testCoroutineRule.testDispatcherProvider)
    }

    @Test
    fun getRepositories_Success() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(getRepositoriesUseCase.execute()).thenReturn(Result.Success(mock()))
        }
    }

    @Test
    fun getRepositories_Error() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(getRepositoriesUseCase.execute()).thenReturn(Result.Error(mock()))
        }
    }


}