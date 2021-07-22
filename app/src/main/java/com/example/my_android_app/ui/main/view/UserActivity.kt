package com.example.my_android_app.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_android_app.R

class UserActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val intent = intent
        val logUserName = intent.getStringExtra("UserName")
        val logUserPass = intent.getStringExtra("UserPass")
        val tvLogUserName = findViewById<TextView>(R.id.tvLoginUserName)
        val tvLogUserPass = findViewById<TextView>(R.id.tvLoginUserPass)
        tvLogUserName.text = logUserName
        tvLogUserPass.text = logUserPass

    }
}