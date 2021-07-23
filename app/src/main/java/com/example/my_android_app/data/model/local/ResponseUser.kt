package com.example.my_android_app.data.model.local

import com.example.my_android_app.data.UiUser
import com.google.gson.annotations.SerializedName

data class ResponseUser (
    @SerializedName("data")
    var data: UiUser? = null ,
    @SerializedName("status")
    var status: Boolean? = null
    )