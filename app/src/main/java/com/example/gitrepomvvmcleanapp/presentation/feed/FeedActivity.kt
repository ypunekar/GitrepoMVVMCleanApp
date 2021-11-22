package com.example.cleanarchpoc.presentation.feed

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProviders
import com.example.gitrepomvvmcleanapp.R
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
import com.example.gitrepomvvmcleanapp.presentation.base.BaseActivity
import javax.inject.Inject


class FeedActivity : BaseActivity<FeedViewModel>() {

    @Inject
    lateinit var factory: FeedViewModelFactory
    var repoList: List<Repositories> = mutableListOf()




    override fun createViewModel(): FeedViewModel {
        return ViewModelProviders.of(this, factory).get(FeedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createFeedComponent().inject(this)
       super.onCreate(savedInstanceState)
        setContent {

            val recipes = viewModel.getCountrisLiveData().value

            for(recipe in recipes){
                Log.d(TAG, "RECIPE: ${recipe.projectName}")
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "RecipeList",
                    style = TextStyle(
                        fontSize = TextUnit.Companion.Unspecified
                    )
                )
                Text(
                    text = "RecipeList",
                    style = TextStyle(
                        fontSize = TextUnit.Companion.Unspecified
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                       viewModel.loadCountries()
                    }
                ) {
                    Text(text = "PERFORM SEARCH")
                }
            }
        }
       // viewModel.loadCountries()

        observeViewModel()
       // setupViewListeners()
    }

    private fun observeViewModel() {


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



