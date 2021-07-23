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
            this.status = false
        }
    }
    //chuyen responseUser thanh userEntity de luu xuong db
    //tu userEntity doi thanh uiUser de tra du lieu ra

    suspend fun saveUser(responseUser: ResponseUser)
    {
        val resUser  = UserEntity( responseUser.data!!.userName,
                                    responseUser.data!!.passWord,
                                    responseUser.status!!)
        addUser(resUser)
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
