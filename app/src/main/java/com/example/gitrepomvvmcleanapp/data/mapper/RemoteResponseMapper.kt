package com.example.gitrepomvvmcleanapp.data.mapper


import RepositoryResponse
import com.example.gitrepomvvmcleanapp.domain.model.Repositories

object RemoteResponseMapper {
    fun toDomain(data: List<RepositoryResponse>): List<Repositories> {
       var repositories = mutableListOf<Repositories>()
        for (i in data){
            repositories.add(Repositories( i.name,i.description?:"",i.ownerRemote))
        }
        return repositories;
    }
}