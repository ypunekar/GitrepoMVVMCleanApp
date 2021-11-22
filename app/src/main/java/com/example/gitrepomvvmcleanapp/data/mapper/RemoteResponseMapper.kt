package com.example.gitrepomvvmcleanapp.data.mapper

import com.example.gitrepomvvmcleanapp.data.model.repositorylist.RepositoryResponse
import com.example.gitrepomvvmcleanapp.domain.model.repositorylist.Repositories

object RemoteResponseMapper {
    fun toDomain(data: List<RepositoryResponse>): List<Repositories> {
       var repositories = mutableListOf<Repositories>()
        for (i in data){
            repositories.add(Repositories( i.name,i.description?:"",i.ownerRemote,i.ownerRemote.login))
        }
        return repositories;
    }
}