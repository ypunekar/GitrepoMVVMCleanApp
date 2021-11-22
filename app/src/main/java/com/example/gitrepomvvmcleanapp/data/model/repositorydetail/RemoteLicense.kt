package com.example.example

import com.google.gson.annotations.SerializedName

   
data class RemoteLicense (

   @SerializedName("key") var key : String,
   @SerializedName("name") var name : String,
   @SerializedName("spdx_id") var spdxId : String,
   @SerializedName("url") var url : String,
   @SerializedName("node_id") var nodeId : String

)