package com.example.mylibrary

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("name")
    var name: String = "",
    @SerializedName("gender")
    var gender: String = ""
): Serializable



