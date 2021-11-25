package com.example.gitrepomvvmcleanapp.presentation.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProviders
import coil.compose.rememberImagePainter
import com.example.cleanarchpoc.presentation.feed.RepositoryDetailViewModelFactory
import com.example.gitrepomvvmcleanapp.presentation.base.BaseActivity
import javax.inject.Inject

class RepositoryDetailActivity :  BaseActivity<RepositoryDetailViewModel>(){
    @Inject
    lateinit var factory: RepositoryDetailViewModelFactory
    lateinit var repositoryDetailViewModel:RepositoryDetailViewModel
    lateinit var detailScreen : DetailScreen;

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createRepositoryDetailComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContent{
            repoDetailView(repositoryDetailViewModel)
            val res = repositoryDetailViewModel.repositoryDetail.value
            if (res != null) {
                detailScreen=DetailScreen(res.profilePicture,res.username,res.description,res.starCount.toString(),res.forkCount.toString())
                updateData(detailScreen)
            }
        }
    }

    override fun createViewModel(): RepositoryDetailViewModel {
        repositoryDetailViewModel= ViewModelProviders.of(this, factory).get(RepositoryDetailViewModel::class.java)
        return repositoryDetailViewModel
    }
}
@Composable
fun repoDetailView(viewModel: RepositoryDetailViewModel){
    val context = LocalContext.current
    val intent = (context as RepositoryDetailActivity).intent
    val repoName = intent.getStringExtra("repo")
    val username = intent.getStringExtra("username")
    viewModel.getDetails(username.toString(),repoName.toString())

}

@Composable
fun updateData(detailScreen: DetailScreen){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(detailScreen.s1),
            contentDescription = "123",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                    .size(200.dp)
                .clip(CircleShape) // clip to the circle shape
                .border(1.dp, Color.Gray, CircleShape))
        Text(
            style = MaterialTheme.typography.subtitle2,
            text =detailScreen.s2,
            color=androidx.compose.ui.graphics.Color.Black,
            modifier = Modifier.padding(10.dp)

        )
        Text(
            text =detailScreen.s3 ,
            color= androidx.compose.ui.graphics.Color.Black,
            modifier = Modifier.padding(16.dp)
        )
        Row() { Text(
            text ="Star:",
            color=androidx.compose.ui.graphics.Color.Black,
            modifier = Modifier.padding(8.dp)
        )
            Text(
                text =detailScreen.s4,
                color=androidx.compose.ui.graphics.Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row(){
            Text(text ="Fork:", color=androidx.compose.ui.graphics.Color.Black, modifier = Modifier.padding(8.dp))
            Text(text =detailScreen.s5 , color= androidx.compose.ui.graphics.Color.Black, modifier = Modifier.padding(8.dp))
        }
    }
}

data class DetailScreen(val s1:String,val s2:String,val s3:String,val s4:String,val s5:String)