package com.example.my_android_app.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.my_android_app.R
import com.example.my_android_app.data.UiUser
import com.example.my_android_app.ui.main.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*


@AndroidEntryPoint
class LoginActivity :AppCompatActivity()
{
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle","onCreate")
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val userName = edtLoginUserName.text.toString()
            val passWord = edtLoginPass.text.toString()
            val uiUser = UiUser().apply {
                this.userName = userName
                this.passWord = passWord
            }

            loginViewModel.responseUserApi(uiUser)
        }

        loginViewModel.uiUser.observe(this, {
            Log.d("TagH","status ${it.status}")
            if(it.status == true)
            {
                startActivity(Intent(this,UserActivity::class.java))
            }else{
                Toast.makeText(this,"Nhap sai UserName hoac PassWord",Toast.LENGTH_LONG).show()
            }
        })


//            val check = loginViewModel.checkStatusUser(userName,passWord)
//            Log.d("TagF","Status ${check.status}")
//            if(check.status)
//            {
//                startActivity(Intent(this,UserActivity::class.java))
//            }else{
//                Toast.makeText(this,"Nhap sai User hoac Pass",Toast.LENGTH_LONG).show()
//            }

//            val check  = loginViewModel.checkStatusUser(user)
//            val nameUserLog = check.userName
//            val passUserLog = check.userPass
//            val checkStatus = check.status
//            if (checkStatus==true)
//            {
//                val intent = Intent(this,UserActivity::class.java)
////                intent.putExtra("UserName",nameUserLog)
////                intent.putExtra("UserPass",passUserLog)
//                startActivity(intent)
//
//            }else{
//                Toast.makeText(this,"Nhap sai User hoac Pass",Toast.LENGTH_LONG).show()
//            }


    }


}