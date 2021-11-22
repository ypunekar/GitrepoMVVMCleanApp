package com.example.cleanarchpoc.presentation.feed

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProviders
import com.example.gitrepomvvmcleanapp.R
import com.example.gitrepomvvmcleanapp.domain.model.Repositories
import com.example.gitrepomvvmcleanapp.presentation.base.BaseActivity
import javax.inject.Inject


class FeedActivity : BaseActivity<FeedViewModel>(R.layout.activity_main) {

    @Inject
    lateinit var factory: FeedViewModelFactory
    var repoList: List<Repositories> = mutableListOf()




    override fun createViewModel(): FeedViewModel {
        return ViewModelProviders.of(this, factory).get(FeedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createFeedComponent().inject(this)
        super.onCreate(savedInstanceState)
        viewModel.loadCountries()

        observeViewModel()
       // setupViewListeners()
    }

    private fun observeViewModel() {

        viewModel.getCountrisLiveData().observe { remoteRepo ->
           // DataProvider.repoList= remoteRepo as MutableList<Repositories>
        }
        viewModel.isShowProgressBarLiveData.observe { isShow ->
            when (isShow) {
                true -> {
                  //  progressBar.visibility = View.VISIBLE
                }
                else -> {
                  //  progressBar.visibility = View.GONE
                }
            }
        }

        viewModel.getShowErrorLiveData().observe { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

}



