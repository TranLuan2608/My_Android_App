package com.example.my_android_app.ui.main.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_android_app.data.UiUser
import com.example.my_android_app.data.model.local.UserEntity
import com.example.my_android_app.repository.LoginRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class LoginViewModel @ViewModelInject constructor(
    private val loginRepository: LoginRepository
): ViewModel()
{
    private val _user = MutableLiveData<UiUser>()
    val uiUser: LiveData<UiUser>  get() = _user


    fun responseUserApi(uiUser: UiUser){
        viewModelScope.launch {
            loginRepository.dayLaApi(uiUser).let {
                loginRepository.saveUser(loginRepository.dayLaApi(uiUser)).collect {
                    if(it)
                    {
                        loginRepository.checkUser(uiUser.userName,uiUser.passWord).collect {
                            val uiGetUser = UiUser().apply {
                                    this.userName = it.userName
                                    this.passWord = it.userPass
                                    this.status = it.status
                            }
                            _user.postValue(uiGetUser)
                        }
                    }
                }

            }
        }
    }


     fun addUserLog(user: UserEntity)
    {
        viewModelScope.launch {
            loginRepository.addUser(user)
        }

    }
     fun checkStatusUser(nameUserLog: String, passUserLog: String)
    {
        viewModelScope.launch {
            Log.d("TagF","Status onDelay")
            loginRepository.checkUser(nameUserLog,passUserLog).let {
//                val userUi = UiUser().apply {
//                    this.userName = it.userName
//                    this.passWord = it.userPass
//                    this.status = it.status
//                }
//                _user.postValue(userUi)
            }
        }
    }
}