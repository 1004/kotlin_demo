package com.example.kotlin_demo

/**
 * 创建时间: 2020/10/22 09:34 <br>
 * 作者: xiekongying <br>
 * 描述:
 */
class KotlinType {


  //泛型接口
  interface Eat<T>{
    fun eat(t:T)
    fun getT():T
  }

  //泛型类 ,泛型先定义后使用
  abstract class Color<T>(var t:T){
    abstract fun prinntColor()
  }

  //泛型方法  返回值可能为空
  fun <T> fromJson(json:String,clazz:Class<T>):T?{
    var t:T ?= clazz.newInstance()
    return t;
  }

  //泛型上限
  fun <T:Comparator<T>?> sort(list: List<T>?):Unit{}

  //多泛型上限
  fun <T> test(list: List<T>):List<T>
    where T:CharSequence,T:Comparator<T>{
    return list.filter { true }.map { it }
  }

  //out ? extends    in : ? super
  fun sumOfList(list: List<out Number>){

  }

}