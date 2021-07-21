package com.example.my_android_app.ui.main.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.my_android_app.R
import com.example.mylibrary.FragmentTwo
import com.example.mylibrary.User
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    var userName = ""
    val LAUNCH_ACTIVITY = 1991
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle","onCreate")
        setContentView(R.layout.activity_main)


        val edtUserName = findViewById<EditText>(R.id.edtUserName)
        btnAddUserName.setOnClickListener {
            userName = edtUserName.text.toString()
            Log.d("TagN","NameMain $userName")
//            val intent = Intent(this,ActivityTestLibrary::class.java).apply {
//
////                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
////                this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//
//            }
//            intent.putExtra("UserName",userName)
////            resultLauncher.launch(intent)
//            startActivityForResult(intent,LAUNCH_ACTIVITY)

            var user = User().apply {
                this.name = userName
                this.gender = "Male"
            }
            //day la lan thu 5
//            var nameUser = user.name
//            nameUser = userName

            val bundle = Bundle()
            bundle.putString("edttext", userName)
            bundle.putSerializable("user", user)
            val fragmentTwo = FragmentTwo().apply {
                this.arguments = bundle
            }

            val manager: FragmentManager = this.supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_one, fragmentTwo, "FragmentTwo")
            transaction.addToBackStack(null)
            transaction.commit()




        }

        val manager: FragmentManager = this.supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.fragment_one, FragmentOne(), "FragmentOne")
        transaction.addToBackStack(null)
        transaction.commit()



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