package com.example.kotlin_demo

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.Result.Companion

/**
 * 创建时间: 2020/11/03 09:51 <br>
 * 作者: xiekongying <br>
 * 描述: 协程
 */
class CoroutineScne {
  val TAG = "CoroutineScne"

  /**
   * 3个异步请求串行执行
   */
  public fun startScene1() {
    Log.i(TAG,"start---")
    GlobalScope.launch(Dispatchers.Main) {
      Log.i(TAG,"start_xiecheng---")
      request1()
      request2()
      request3()
      Log.i(TAG,"end_xiecheng---")
    }
    Log.i(TAG,"end---")
  }

  /**
   * request1 执行完后，并行执行reqeust2和request3，都执行完毕后执行updataUI
   */
  public fun startScene2(){
    GlobalScope.launch(Dispatchers.Main) {
      val value1 = request1()
      val as1 = GlobalScope.async { request2()}
      val as2 = GlobalScope.async { request3() }
      updataUI(as1.await(),as2.await())
    }
  }

  public  fun startScene3(){
    GlobalScope.launch(Dispatchers.Main) {
      val readContent = readContent()
      Log.i(TAG,"内容：$readContent")
    }
  }

  /**
   * 自定义挂起方法
   */
  suspend fun readContent():String{
    return suspendCancellableCoroutine {
      continuation->
      Thread(Runnable {
        Thread.sleep(2*1000)
        continuation.resumeWith(Result.success("来自写成内容"))
      }).start()
    }
  }

  suspend fun request1(): String {
    delay(2 * 1000)
    Log.i(TAG, "reqeust1 work on ${Thread.currentThread().name}")
    return "request from request1"
  }

  suspend fun request2(): String {
    delay(2 * 1000)
    Log.i(TAG, "reqeust2 work on ${Thread.currentThread().name}")
    return "request from request2"
  }

  suspend fun request3(): String {
    delay(2 * 1000)
    Log.i(TAG, "reqeust3 work on ${Thread.currentThread().name}")
    return "request from request3"
  }

  fun updataUI(await: String, await1: String) {
    Log.i(TAG, "updataUI ${Thread.currentThread().name}")
  }

}