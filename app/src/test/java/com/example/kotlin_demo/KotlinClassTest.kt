package com.example.kotlin_demo

import org.junit.Test

/**
 * 创建时间: 2020/10/21 11:04 <br>
 * 作者: xiekongying <br>
 * 描述:
 */

class KotlinClassTest {

  @Test
  fun test() {
    test8()
  }

  //主构造方法 constructor可以省略
  class KonlinClass constructor(name: String) {

    //次构造方法，可以声明多个 ,必须先调用主构造方法
    constructor(age: Int, name: String) : this(name) {
      println("$age")
    }

  }

  //所有类是final 不能被继承，如果能被继承，必须加Open
  open class Animal(age: Int) {
    init {
      println(age)
    }

    //如果要被子类复写，必须也得加open
    open fun eat() {

    }

    //属性被子类改变，必须也得加open
    open val foot: Int = 0;

    val simple: Int?
      get() {
        return 1
      }

  }

  //继承
  class Dog : Animal {

    override val foot = 5

    //次构造
    constructor(age: Int) : super(age)

    //复写父类
    override fun eat() {
      super.eat()
    }

    //延迟初始化
    lateinit var shop: Shop
    fun setup() {

    }

    fun test() {
      if (::shop.isInitialized) {
        shop.address
      }
    }

  }

  //Get,Set
  class Shop {
    val name: String = "C++"
    val address: String? = null;
    var isClose: Boolean
      get() = name.equals("C+")
      set(value) {
        isClose = value;
        println(value)
      }
  }

  //抽象类和方法
  abstract class IPrinter {
    abstract fun print()
  }

  class LogPrint : IPrinter() {
    override fun print() {
      println("抽象")
    }
  }

  //抽象接口
  interface IStudy {
    var time: Int
    fun discuss();

    //可以实现
    fun learn() {
      println("开始学习了")
    }
  }

  class MyStudy(override var time: Int) : IStudy {
    override fun discuss() {
    }
  }

  interface A {
    fun foo() {

    }
  }

  interface B {
    fun foo() {

    }
  }

  class C : A, B {
    override fun foo() {
      super<A>.foo()
    }
  }

  open class Phone constructor(var phone: String) {
    open fun print() {
      println(phone)
    }
  }

  //数据类： 必须有个参数
  open class Person(var name: String) {
    var phone: Phone? = null;

    fun addPhone(phone: Phone) {
      this.phone = phone;
      phone.print()
    }

  }

  fun test8() {
    //匿名内部类对象
    Person("xky").addPhone(object : Phone("123") {
      override fun print() {
        super.print()
      }
    })
  }

  //匿名类对象
  fun foo() {
    var ab = object {
      var x: Int = 0
      var y: Int = 1;
    }
  }

  //静态类 ? 表示可以为空
  object DataUtil {
    fun <T> isEmpty(list: ArrayList<T>?): Boolean {
      return list?.isEmpty() ?: false//list是否为空，不为空调用isEmpty,否则为false
    }
  }

  //半生对象
  class Student(var name: String) {
    //类种静态方法
    companion object {
      var student = Student("xky")
      fun print(){
        println("坎坎坷坷")
      }
    }
  }

  fun test3(){
    Student.student
    Student.print()
    var t = Teacher("xky")
    t.name
  }

  //数据类的应用
  data class Teacher(var name: String)



}

