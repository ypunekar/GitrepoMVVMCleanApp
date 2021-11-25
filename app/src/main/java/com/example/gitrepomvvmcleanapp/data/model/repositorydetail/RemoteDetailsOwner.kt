package com.example.example

import com.google.gson.annotations.SerializedName

   
data class RemoteDetailsOwner (@SerializedName("login") var login : String,
   @SerializedName("avatar_url") var avatarUrl : String,
)