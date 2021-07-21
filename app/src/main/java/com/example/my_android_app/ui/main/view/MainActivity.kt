package com.example.my_android_app.ui.main.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.my_android_app.R
import com.example.mylibrary.ActivityTestLibrary
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    var userName = ""
    val LAUNCH_ACTIVITY = 1991
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtUserName = findViewById<EditText>(R.id.edtUserName)
        btnAddUserName.setOnClickListener {
            userName = edtUserName.text.toString()
            Log.d("TagN","NameMain $userName")
            val intent = Intent(this,ActivityTestLibrary::class.java).apply {


            }
            intent.putExtra("UserName",userName)
//            resultLauncher.launch(intent)
            startActivityForResult(intent,LAUNCH_ACTIVITY)
        }

    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == LAUNCH_ACTIVITY )
        {
            if(resultCode == Activity.RESULT_OK)
            {
                val namSinh = data?.getStringExtra("NamSinh")
                Log.d("TagM","Nam Sinh $namSinh")
                tvNamSinh.text = namSinh
                Log.d("TagM","NameMain $userName")
                tvUserName.text = userName
                Toast.makeText(this,"Result ok", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Result cancel", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}
// viet form nhạp ten user > ActivityLibrary > lấy tên user nhập năm sinh
// tắt form main hiện tên + năm sinh

//    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            // There are no request codes
//            val data: Intent? = result.data
//            val namSinh = data?.getStringExtra("NamSinh")
//            Log.d("TagM","Nam Sinh $namSinh")
//            tvNamSinh.text = namSinh
//            Log.d("TagM","NameMain $userName")
//            tvUserName.text = userName
//            Toast.makeText(this,"Result ok", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//        return super.onCreateView(name, context, attrs)
//
//