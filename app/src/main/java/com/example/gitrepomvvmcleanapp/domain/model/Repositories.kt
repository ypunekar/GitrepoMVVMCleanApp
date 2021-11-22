package com.example.gitrepomvvmcleanapp.domain.model

import com.example.gitrepomvvmcleanapp.data.model.OwnerRemote

data class Repositories(
    var projectName: String, var Description:String?, var ownerRemote: OwnerRemote
 )


