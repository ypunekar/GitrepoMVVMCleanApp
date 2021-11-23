package com.example.cleanarchpoc.presentation.feed

import android.content.ContentValues.TAG
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
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
            viewModel.loadCountries()
            val recipes = viewModel.getCountrisLiveData().value

            for(recipe in recipes){
                Log.d(TAG, "RECIPE: ${recipe.projectName}")
            }
            AllPlants(recipes)

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

@Composable
fun AllPlants (platList: List<Repositories>){
    Scaffold(
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(platList){plant ->

                plant.Description?.let { it1 -> PlantCard(plant.projectName, it1) }
            }
        }
    }
}
@Composable
fun PlantCard(name: String, description: String) {
    Card(
        modifier = Modifier
            // The space between each card and the other
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth(),
                    color = Color.Black
                    )
                Text(
                    text = description,
                    color = Color.Gray,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

