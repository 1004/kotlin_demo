package com.example.kotlin_demo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KotlinBase {
  @Test
  fun addition_isCorrect() {
//    arrayType()
//    testCollect();
//    testCollectSort()
    test7()
  }

  fun byteType() {
    var num1 = 10;
    println("$num1");
  }

  fun printType(param: Any) {
    println("$param is ${param::class.simpleName} type")
  }

  fun arrayType() {
    var array1 = arrayOf(1, 2, 3)
    var array2 = arrayOfNulls<Int>(3)
    array2[0] = 3;
    array2[1] = 4;
    array2[2] = 5;

    var array3 = Array(5) { i ->
      (i * 4).toString()
    }

    var array4 = intArrayOf(1, 2, 3)

    var array5 = IntArray(4) { 55 }

    for (item in array5) {
      println(item)
    }

    for (i in array5.indices) {
      println("$i->${array5[i]}")
    }

    for ((index, item) in array5.withIndex()) {
      println("$index->$item")
    }

    array5.forEach { println(it) }

    array5.forEachIndexed() { index, i ->
      println("$index --> $i")
    }

  }

  fun testCollect() {
    //不可变集合
    var c1 = listOf(1, 32, 4)
    var c2 = setOf("sd", "34");
//    可变集合
    var c3 = mutableListOf(12, 34, 5, 5)
    c3.add(54)
    c3.removeAt(1)
    c3[0] = 23
    println(c3)
  }

  fun testCollectSort() {
    var c4 = mutableListOf(23, 4, 1, 344, 42)
    c4.sort()
    println(c4)
    c4.sortDescending()
    println(c4)

    data class Language(var name: String, var scre: Int)

    var languages: MutableList<Language> = mutableListOf()
    languages.add(Language("java", 34))
    languages.add(Language("C", 90))
    languages.sortBy { it.scre }
    println(languages)
    var comparator = Comparator<Language>() { a, b ->
      b.scre - a.scre
    };
    languages.sortWith(comparator)
    println(languages)

    var d1 = mutableSetOf("kk")

    var map = mutableMapOf(Pair("key1", "value1"), Pair("key2", "value2"))
    println(map.containsKey("key1"))
    map.put("key3", "value4")
    map.forEach() {
      println("key ${it.key} value ${it.value}")
    }

  }

  class Person {
    //普通成员方法
    fun test1() {

    }

    //静态方法
    companion object {
      fun test2() {

      }
    }
  }

  //静态类
  object MyUtils {
    //静态方法
    fun test3() {

    }
  }

  //单表达式
  fun add(v1: Int, v2: Int): Int = v1 + v2

  //默认值方法 减少方法重载
  fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {

  }

  //可变参数
  fun write(vararg str: Char): String {
    var v = StringBuffer();
    for (char in str) {
      v.append(char)
    }
    return v.toString()
  }

  //局部方法
  fun maginc(): Int {
    fun foo(v: Int): Int {
      return v * 10;
    }

    var v1 = (0..100).random()
    return foo(v1)
  }

  //Lambda 表达式 -->匿名方法
  var test = { println("无参数") }

  //2个参数，一个返回值
  var test2: (Int, Int) -> Int = { a, b -> a + b }
  var test3 = { a: Int, b: Int -> a + b }

  fun test5() {

    var map = mapOf("key1" to "value1", "key2" to "value2")
    map.forEach() { (e, v) ->
      println(e)
    }
  }

  //高阶函数- 函数作为参数

  //  扩展函数
  fun List<Int>.sum(callback: (Int) -> Unit): Int {
    var result = 0;
    for (i in this) {
      result += i
      callback(i)
    }
    return result;
  }

//  函数作为返回值  定义一个返回值->Lambud返回值类型   :后面也是正常函数的一个返回值类型

  fun List<String>.toIntSum(): (Int) -> Float {
    return fun(scale: Int): Float {
      var result = 0f;
      for (i in this) {
        result += i.toInt() * scale
      }
      return result
    }
  }

  fun test6() {
    val testdata = listOf(23, 23, 3, 4, 4)
    testdata.sum { println(it) }
    val testStr = listOf("23", "3")
    testStr.toIntSum()(23)
  }

  //闭包
  fun testClouse(v1: Int): (v2: Int, (v3: Int) -> Unit) -> Unit {
    return fun(v2: Int, printe: (Int) -> Unit) {
      printe(v1 + v2)
    }
  }

  data class Result(val msg: String, val code: Int)

  fun test7() {
    var result = Result("success", 0)
    val (msg, code) = result;
    println(msg)
    //函数类型变量
    var temp: ((Int)->Boolean?) ?=null
    temp = {
      num->(num>9)
    }
    temp(10)
  }

  //匿名方法
  val fun8 = fun(x: Int, y: Int): Int {
    return x + y
  }

  //普通匿名方法，=返回值
  val fun9 = fun(x: Int, y: Int): Int = x + y




}