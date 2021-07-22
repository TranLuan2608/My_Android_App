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
            val user = UiUser().apply {
                this.userName = userName
                this.passWord = passWord
                this.status = true
            }
            loginViewModel.addUser(user)

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
    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle","onResume")

    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle","onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle","onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle","onDestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle","onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle","onPause")
    }


}