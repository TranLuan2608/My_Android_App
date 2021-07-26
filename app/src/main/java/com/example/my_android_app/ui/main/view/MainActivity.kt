package com.example.my_android_app.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.my_android_app.R


class MainActivity : AppCompatActivity() {
    var userName = ""
    val LAUNCH_ACTIVITY = 1991
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "onCreate")
        setContentView(R.layout.activity_main)
        //test1()
        //test7()
        //test8()
//        val arg = arrayOf(1, 2, 3, 4)
//        test("String")
//        test(10)
//        test(arg)
//        test(2.5)
        val a = layGiaTriTraVe<Int,String>(2)
        val b = layGiaTriTraVe<Int,String>(3)
        //khong
//        val c = layGiaTriTraVe<Int,Long>(5)
        Log.d("TagL", "Gia tri tra ve a $a")
        Log.d("TagL", "Gia tri tra ve b $b")
//        Log.d("TagL", "Gia tri tra ve b $c")
    }
}
//generics là một class có thể implement và có thể thay đổi kiểu dữ liệu tham số truyền vào
//vì vậy ta có thể truyền vào một list dữ liệu
//la thuat ngu co nghia la tham so hoa du lieu
//mot class, interface, method ma thuc hien tren 1 tham so goi la genetics
//khai bao mot class genetics giong nhu khai bao mot class bth nhung them sau no la
//kieu du lieu tong quat
//khi hoat dong cua class can co nhieu tham so truyen vao

fun <T> test(text: T) {
    println(text.toString())
}
//truyen vao mot gia tri bat ky in ra kieu gia tri mong muon
fun <T, V>layGiaTriTraVe(text: T): V? {
    return text.toString() as? V
}

class MyClass<T>(text: T) {
    var name = text
    init {
        Log.d("TagU", "Generics $name")
    }
}

private fun test1() {
    var name: MyClass<String> = MyClass("Geeks for Geeks")
    var rank: MyClass<Int> = MyClass(12)
}


open class Father()
class Son : Father()

// supertype = subtype Covariance
class Person<out T>(val value: T) {
    fun get(): T {
        return value
    }
}

fun test9() {
    val sonObject = Person(Son())
    val fatherObject: Person<Father>
    fatherObject = sonObject

}

class OutClass<out T>(private val value: T) {
    fun get(): T {
        return value
    }
}

private fun test2() {
    val out = OutClass("string")
    val ref: OutClass<Any> = out
}

//subtype = supertype
// Contravariance
class InClass<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

private fun test3() {
    val inClassObject: InClass<Number> = InClass()
    val ref = inClassObject
}

//class su dung ca in va out (Invariance)
fun test4() {
    // val x: MyClass2<Any> = MyClass2<Int>()        // Error: Type mismatch
    val y: MyClass2<out Any> = MyClass2<String>() // Works since String is a subtype of Any
    //val z: MyClass2<in String> = MyClass2<Any>() // Error since Any is a supertype of String
}

class MyClass2<T>

fun test5() {
    val y: MyClass3<Any> = MyClass3<String>() // Compiles without error
}

class MyClass3<out T>

fun test6() {
    var a: Container<Dog> = Container<Animal>()  //compiles without error
    //var b: Container<Animal> = Container<Dog>()  //gives compilation error
}

open class Animal
class Dog : Animal()
class Container<in T>

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    // copying (from) array to (to) array
    for (i in from.indices)
        to[i] = from[i]
    // printing elements of array in which copied
    for (i in to.indices) {
        var to = to[i]
        Log.d("TagU", "Generics $to")
    }
}

fun test7() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any: Array<Any> = Array<Any>(3) { "" }
    copy(ints, any)

}

//Star projection
fun printArray(array: Array<*>) {
    array.forEach {
        Log.d("TagU", "Generics $it")
    }
}

fun test8() {
    val name = arrayOf(1, "for", "Geeks")
    printArray(name)
}


//        val edtUserName = findViewById<EditText>(R.id.edtUserName)
//        btnAddUserName.setOnClickListener {
//            userName = edtUserName.text.toString()
////            Log.d("TagN","NameMain $userName")
////            val intent = Intent(this, ActivityTestLibrary::class.java).apply {
////
////                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
////                this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
////
////            }
////            intent.putExtra("UserName",userName)
//////            resultLauncher.launch(intent)
////            startActivityForResult(intent,LAUNCH_ACTIVITY)
//
//            var user = User().apply {
//                this.name = userName
//                this.gender = "Male"
//            }
//            //day la lan thu 5
////            var nameUser = user.name
////            nameUser = userName
//
//            val bundle = Bundle()
//            bundle.putString("edttext", userName)
//            bundle.putSerializable("user", user)
//            val fragmentTwo = FragmentTwo().apply {
//                this.arguments = bundle
//            }
//
//            val manager: FragmentManager = this.supportFragmentManager
//            val transaction: FragmentTransaction = manager.beginTransaction()
//            transaction.replace(R.id.fragment_one, fragmentTwo, "FragmentTwo")
//            transaction.addToBackStack(null)
//            transaction.commit()
//
//
//
//
//        }
//
//        val manager: FragmentManager = this.supportFragmentManager
//        val transaction: FragmentTransaction = manager.beginTransaction()
//        transaction.add(R.id.fragment_one, FragmentOne(), "FragmentOne")
//        transaction.addToBackStack(null)
//        transaction.commit()
//
//


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == LAUNCH_ACTIVITY )
//        {
//            if(resultCode == Activity.RESULT_OK)
//            {
//                val namSinh = data?.getStringExtra("NamSinh")
//                Log.d("TagM","Nam Sinh $namSinh")
//                tvNamSinh.text = namSinh
//                Log.d("TagM","NameMain $userName")
//                tvUserName.text = userName
//                Toast.makeText(this,"Result ok", Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(this,"Result cancel", Toast.LENGTH_LONG).show()
//            }
//        }
//    }

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