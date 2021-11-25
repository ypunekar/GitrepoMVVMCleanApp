package com.example.gitrepomvvmcleanapp.data.model.repositorylist

import com.google.gson.annotations.SerializedName

data class RepositoryResponse (
    @SerializedName("name") val name : String,
    @SerializedName("full_name") val full_name : String,
    @SerializedName("private") val private : Boolean,
    @SerializedName("owner") val ownerRemote : OwnerRemote,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("description") val description : String
    )