package com.example.my_android_app.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_android_app.data.model.local.ResponseUser
import com.example.my_android_app.data.UiUser
import com.example.my_android_app.data.model.local.UserEntity
import com.example.my_android_app.repository.LoginRepository
import kotlinx.coroutines.launch


class LoginViewModel @ViewModelInject constructor(
    private val loginRepository: LoginRepository
): ViewModel()
{
    private val _user = MutableLiveData<UiUser>()
    val uiUser: LiveData<UiUser>  get() = _user
    private var userLog: UserEntity = UserEntity("","",false)


    fun fetchUser(uiUser: UiUser): ResponseUser {
        return loginRepository.dayLaApi(uiUser)
    }


     fun addUserLog(user: UserEntity)
    {
        viewModelScope.launch {
            loginRepository.addUser(user)
        }

    }
     fun checkStatusUser(nameUserLog: String, passUserLog: String) :UserEntity
    {
        viewModelScope.launch {
             userLog = loginRepository.checkUser(nameUserLog,passUserLog)
        }
        return  userLog
    }
}