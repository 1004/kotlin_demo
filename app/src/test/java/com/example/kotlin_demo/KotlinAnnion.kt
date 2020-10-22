package com.example.kotlin_demo

import org.junit.Test
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FIELD

/**
 * 创建时间: 2020/10/22 10:42 <br>
 * 作者: xiekongying <br>
 * 描述:注解【标签】
 */
class KotlinAnnion {

  @Retention(RUNTIME)
  @Target(CLASS)
  annotation class MyAnno(val value: String)

  @Target(FIELD)
  @Retention(RUNTIME)
  annotation class MyFiled(val value:String)

  @MyAnno("测试")
  class MyBox {

    @MyFiled("姓名字段")
    var name:String ?= null;
  }

  @Test
  fun test(){
    testMyBox(MyBox())
  }

  fun testMyBox(box:MyBox){
    val annotations = box.javaClass.annotations
    var myAnno = annotations.find { it is MyAnno } as? MyAnno
    println(myAnno?.value)
    val annotation = box::class.java.getDeclaredField("name").getAnnotation(MyFiled::class.java)
    println(annotation.value)
  }




}