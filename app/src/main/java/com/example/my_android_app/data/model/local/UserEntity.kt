package com.example.my_android_app.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "user_table")
data class UserEntity (
    @PrimaryKey
    @SerializedName("userName")
    var userName: String ,
    @SerializedName("userPass")
    var userPass: String,
    @SerializedName("status")
    var status: Boolean
)