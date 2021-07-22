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


    fun fetchUser(uiUser: UiUser): ResponseUser {
        return loginRepository.dayLaApi(uiUser)
    }

    fun addUser(uiUser: UiUser)
    {
        viewModelScope.launch {
            loginRepository.insertUser(uiUser)
        }

    }
//    fun checkStatusUser(uiUser: UiUser): UserEntity
//    {
//        return loginRepository.checkUser(uiUser)
//    }
}