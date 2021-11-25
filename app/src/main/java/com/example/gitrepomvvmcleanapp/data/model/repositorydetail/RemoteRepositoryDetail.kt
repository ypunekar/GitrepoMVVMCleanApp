package com.example.gitrepomvvmcleanapp.data.model.repositorydetail

import com.example.example.RemoteDetailsOwner
import com.google.gson.annotations.SerializedName

   
data class RemoteRepositoryDetail (
   @SerializedName("name") var name : String,
   @SerializedName("full_name") var fullName : String,
   @SerializedName("private") var private : Boolean,
   @SerializedName("owner") var owner : RemoteDetailsOwner,
   @SerializedName("description") var description : String,
   @SerializedName("stargazers_count") var stargazersCount : Int,
   @SerializedName("forks_count") var forksCount : Int,
   @SerializedName("forks") var forks : Int,
   )