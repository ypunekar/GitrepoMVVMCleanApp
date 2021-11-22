package com.example.gitrepomvvmcleanapp.domain.model

import com.google.gson.annotations.SerializedName


data class Owner( val login : String,
              val node_id : String,
                  val avatar_url : String,
             val gravatar_id : String,
                val url : String,
                val html_url : String,

)
