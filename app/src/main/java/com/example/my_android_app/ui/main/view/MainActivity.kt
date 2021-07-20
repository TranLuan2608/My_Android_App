package com.example.my_android_app.ui.main.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.my_android_app.R
import com.example.mylibrary.ActivityTestLibrary
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTestLibrary.setOnClickListener {
            var intent = Intent(this,ActivityTestLibrary::class.java).apply {
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        }
    }
}