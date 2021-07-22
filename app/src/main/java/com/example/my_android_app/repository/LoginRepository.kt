package com.example.my_android_app.repository

import com.example.my_android_app.data.model.local.ResponseUser
import com.example.my_android_app.data.UiUser
import com.example.my_android_app.data.model.local.UserDataBase
import com.example.my_android_app.data.model.local.UserEntity
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val db: UserDataBase
) {
    private val userDao = db.userDao()
    fun dayLaApi(uiUser: UiUser?): ResponseUser {
        return ResponseUser().apply {
            this.data = uiUser
            this.status = true
        }
    }
    suspend fun addUser(user: UserEntity)
    {
        userDao.insertUser(user)
    }
    suspend fun checkUser(nameUserLog: String, passUserLog: String): UserEntity
    {
        return userDao.getUser(nameUserLog, passUserLog)
    }

}
