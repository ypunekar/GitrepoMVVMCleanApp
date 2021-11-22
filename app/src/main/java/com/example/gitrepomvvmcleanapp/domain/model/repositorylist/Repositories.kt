package com.example.gitrepomvvmcleanapp.domain.model.repositorylist

import com.example.gitrepomvvmcleanapp.data.model.repositorylist.OwnerRemote

data class Repositories(
    var projectName: String, var Description:String?, var ownerRemote: OwnerRemote,var username:String
 )


