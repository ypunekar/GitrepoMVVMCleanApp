package com.example.gitrepomvvmcleanapp.data.model.repositorylist

import com.google.gson.annotations.SerializedName

data class OwnerRemote (
	@SerializedName("login") val login : String,
	@SerializedName("id") val id : Int,
	@SerializedName("node_id") val node_id : String,
	@SerializedName("avatar_url") val avatar_url : String,
)