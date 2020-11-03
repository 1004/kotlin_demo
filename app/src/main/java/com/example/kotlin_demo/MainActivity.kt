package com.example.kotlin_demo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes

class MainActivity : AppCompatActivity() {
  private var btn1:View ?= null
  private var scene:CoroutineScne ?= null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    scene = CoroutineScne()

    btn1 = findViewById<View>(R.id.btn1)
    btn1?.testClick {
      Toast.makeText(this,"测试",Toast.LENGTH_SHORT).show()
    }

    findViewById<View>(R.id.btn2).setOnClickListener {
      scene?.startScene2()
    }
    findViewById<View>(R.id.btn3).setOnClickListener {
      scene?.startScene3()
    }
//    R.id.btn1.onClick<View>(this){
//      Toast.makeText(this,"测试",Toast.LENGTH_SHORT).show()
//    }
  }

  fun<T:View> T.testClick(block:(T)->Unit){
    this.setOnClickListener {
      block(this)
    }
  }

  fun <T:View> Activity.findById(@IdRes id:Int):T{
    return this.findViewById<T>(id)
  }

  fun<T:View> Int.onClick(activity: Activity,onclick:(T)->Unit){
    activity.findById<T>(this).apply {
      this.setOnClickListener{
        onclick(this)
      }
    }
  }

  fun test(str:String?){
    if (str.isNullOrEmpty()){

    }
  }

}