package com.example.gitrepomvvmcleanapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanarchpoc.domain.util.Result
import com.example.cleanarchpoc.presentation.feed.RepositoryListViewModel
import com.example.gitrepomvvmcleanapp.domain.usecase.GetRepositoriesUseCase
import com.example.gitrepomvvmcleanapp.presentation.detail.RepositoryDetailViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class RepositoryDetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    fun <T> any(): T = Mockito.any<T>()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    inline fun <reified T> mock(): T = Mockito.mock(T::class.java)


    @Mock
    lateinit var getRepositoriesUseCase: GetRepositoriesUseCase

    lateinit var repositoryDetailViewModel: RepositoryDetailViewModel

    @Before
    fun setUp() {
        repositoryDetailViewModel = RepositoryDetailViewModel(getRepositoriesUseCase,testCoroutineRule.testDispatcherProvider)
    }

    @Test
    fun getRepositoriesDetail_Success() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(getRepositoriesUseCase.executeDetails("mojombo","grit")).thenReturn(Result.Success(mock()))
        }

    }

    @Test
    fun getRepositoriesDetail_Failure() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(getRepositoriesUseCase.executeDetails("", "grit"))
                .thenReturn(Result.Error(mock()))
        }
    }


}