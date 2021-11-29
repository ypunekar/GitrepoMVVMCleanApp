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
import com.example.gitrepomvvmcleanapp.presentation.detail.model.DetailScreen
import com.example.gitrepomvvmcleanapp.presentation.detail.ui.repoDetailView
import com.example.gitrepomvvmcleanapp.presentation.detail.ui.updateData
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
                detailScreen= DetailScreen(res.profilePicture,res.username,res.description,res.starCount.toString(),res.forkCount.toString())
                updateData(detailScreen)
            }
        }
    }

    override fun createViewModel(): RepositoryDetailViewModel {
        repositoryDetailViewModel= ViewModelProviders.of(this, factory).get(RepositoryDetailViewModel::class.java)
        return repositoryDetailViewModel
    }
}

