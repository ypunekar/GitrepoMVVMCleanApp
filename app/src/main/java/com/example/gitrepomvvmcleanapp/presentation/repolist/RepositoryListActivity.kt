package com.example.gitrepomvvmcleanapp.presentation.repolist

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProviders
import com.example.cleanarchpoc.presentation.feed.RepositoryListViewModel
import com.example.gitrepomvvmcleanapp.presentation.base.BaseActivity
import com.example.gitrepomvvmcleanapp.presentation.repolist.ui.AllRepositories
import javax.inject.Inject


class RepositoryListActivity : BaseActivity<RepositoryListViewModel>() {

    @Inject
    lateinit var factory: RepositoryListViewModelFactory


    override fun createViewModel(): RepositoryListViewModel {
        return ViewModelProviders.of(this, factory).get(RepositoryListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createFeedComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.loadRepositories()
            val repositories = viewModel.repositoriesMutableState.value

            for (recipe in repositories) {
                Log.d(TAG, "RECIPE: ${recipe.projectName}")
            }
            AllRepositories(repositories,viewModel)

        }

    }

}
