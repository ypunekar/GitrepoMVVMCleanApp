package com.example.gitrepomvvmcleanapp.data.mapper

import com.example.gitrepomvvmcleanapp.data.model.repositorydetail.RemoteRepositoryDetail
import com.example.gitrepomvvmcleanapp.domain.model.repositorydetails.RepositoryDetail

object RepositoryDetailMapper {

        fun toDomain(data: RemoteRepositoryDetail): RepositoryDetail {
           return RepositoryDetail(data.owner.avatarUrl,data.owner.login,data.description,data.forksCount,data.stargazersCount)

    }
}