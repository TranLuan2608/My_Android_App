package com.example.my_android_app.ui.main.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_android_app.data.model.local.ResponseUser
import com.example.my_android_app.data.UiUser
import com.example.my_android_app.data.model.local.UserEntity
import com.example.my_android_app.repository.LoginRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Handler


class LoginViewModel @ViewModelInject constructor(
    private val loginRepository: LoginRepository
): ViewModel()
{
    private val _user = MutableLiveData<UiUser>()
    val uiUser: LiveData<UiUser>  get() = _user


    fun responseUserApi(uiUser: UiUser){
        viewModelScope.launch {
            loginRepository.dayLaApi(uiUser).let {
                loginRepository.saveUser(loginRepository.dayLaApi(uiUser))
                val resUser = UiUser(it.data!!.userName,it.data!!.passWord,it.status)
                _user.postValue(resUser)
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
            delay(2000)
            Log.d("TagF","Status onDelay")
            loginRepository.checkUser(nameUserLog,passUserLog).let {
                val userUi = UiUser(it.userName,it.userPass,it.status)
                _user.postValue(userUi)
            }
        }
    }
}