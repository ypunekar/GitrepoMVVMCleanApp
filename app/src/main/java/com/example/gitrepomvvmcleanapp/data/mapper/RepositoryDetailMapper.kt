package com.example.gitrepomvvmcleanapp.data.mapper

import com.example.example.RemoteRepositoryDetail
import com.example.gitrepomvvmcleanapp.data.model.repositorylist.RepositoryResponse
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories

object RepositoryDetailMapper {

        fun toDomain(data: RemoteRepositoryDetail): RepositoryDetail {
           return RepositoryDetail(data.archiveUrl,data.owner.login,data.description,data.forksCount,data.stargazersCount)

    }
}