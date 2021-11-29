package com.example.gitrepomvvmcleanapp.presentation.repolist.ui

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.cleanarchpoc.presentation.feed.RepositoryListViewModel
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories
import com.example.gitrepomvvmcleanapp.presentation.detail.RepositoryDetailActivity


@Composable
fun AllRepositories(repositories: List<Repositories>, repositoryListViewMode: RepositoryListViewModel){
    Scaffold(
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(repositories){plant ->
                plant.description?.let { it1 -> RepoCard(plant.projectName, it1,plant.username) }
            }
        }
    }
}
@Composable
fun RepoCard(projectName: String, description: String,userName:String) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            // The space between each card and the other
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable{val intent = Intent(context, RepositoryDetailActivity::class.java)
                intent.putExtra("repo", projectName)
                intent.putExtra("username", userName)
                intent.putExtra("IsMale", true)
                context.startActivity(intent)
            },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = projectName,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
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

