package com.example.mylibrary

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityTestLibrary : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_library)
    }
}