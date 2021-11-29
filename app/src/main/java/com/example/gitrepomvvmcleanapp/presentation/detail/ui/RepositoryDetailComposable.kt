package com.example.gitrepomvvmcleanapp.presentation.detail.ui

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
import coil.compose.rememberImagePainter
import com.example.gitrepomvvmcleanapp.presentation.detail.DetailScreen
import com.example.gitrepomvvmcleanapp.presentation.detail.RepositoryDetailActivity
import com.example.gitrepomvvmcleanapp.presentation.detail.RepositoryDetailViewModel

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
            color= Color.Black,
            modifier = Modifier.padding(10.dp)

        )
        Text(
            text =detailScreen.s3 ,
            color= Color.Black,
            modifier = Modifier.padding(16.dp)
        )
        Row() { Text(
            text ="Star:",
            color= Color.Black,
            modifier = Modifier.padding(8.dp)
        )
            Text(
                text =detailScreen.s4,
                color= Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row(){
            Text(text ="Fork:", color= Color.Black, modifier = Modifier.padding(8.dp))
            Text(text =detailScreen.s5 , color= Color.Black, modifier = Modifier.padding(8.dp))
        }
    }
}
