package com.example.kotlin_demo

import org.junit.Test

/**
 * 创建时间: 2020/10/22 11:37 <br>
 * 作者: xiekongying <br>
 * 描述:kotlin 扩展
 */
class KotlinExtension {

  @Test
  fun test(){

  }

  fun swap(){
    var list = mutableListOf<Int>();
    list.swap(1,3)

  }

  //list扩展函数
  fun MutableList<Int>.swap(index1:Int,index2:Int){

  }

  //泛型扩展方法
  fun <T>MutableList<T>.swap2(index1: Int,index2: Int){

  }

  //扩展属性
  val String.lastChar:Char get() = this.get(this.length-1)


  //为半生对象加扩展
  class Jump{
    companion object{}
  }

  fun Jump.Companion.print(str:String){

  }

  fun testJump(){
    Jump.print("hh")
  }

  fun tsetLet(str: String?){
    str?.let {
      //一定不会为空
      println(it.length)
    }

    //限制作用域
    str?.let {
      var str2 = "kkk"
      println(it+str2)
    }

  }

  data class Room(var address:String)

  fun testRun(room: Room){
    room.run {
      println(address)
    }
  }

  fun testApply(room:Room){
    ArrayList<String>().apply {
      add("1")
      add("2")
    }.let {
      println(it)
    }
  }

}
