package com.example.mylibrary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityTestLibrary : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_library)

        val intent = intent
        val userName = intent.getStringExtra("UserName")
        Log.d("TagN","Name $userName")
        val tvUserName = findViewById<TextView>(R.id.tvUserName)


        tvUserName.text = userName


        val namSinh = findViewById<EditText>(R.id.edtNamSinhUser)
        val btnAddNamSinh = findViewById<Button>(R.id.btnAddNamSinh)

        btnAddNamSinh.setOnClickListener {
            val namSinhUser = namSinh.text.toString()
            val returnIntent = Intent()
            returnIntent.putExtra("NamSinh",namSinhUser)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }




    }
}