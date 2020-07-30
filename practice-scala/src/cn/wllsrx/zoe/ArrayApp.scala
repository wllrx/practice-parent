package cn.wllsrx.zoe

import scala.collection.mutable.ArrayBuffer

/**
 * @author zoe
 **/
object ArrayApp {

  def main(args: Array[String]): Unit = {
    forTest()
    mergeTest()
  }

  /**
   * 数组
   */

  /**
   * 创建list
   */
  //不可变数组
  def immutable(): Unit = {
    //声明一个不可变的长度为2的数组
    val arr = new Array[String](2)
    //赋值
    arr(0) = "Java"
    arr(1) = "Scala"
    //使用另一种方式声明数组
    val arr1 = Array("Java", "Scala")
  }

  //可变数组
  def variable(): Unit = {
    val buffer = ArrayBuffer[String]()
    //追加一个值
    buffer += "Java"
    //追加一个数组
    buffer ++= Array("Scala", "go")
  }

  /**
   * 数组处理
   */
  //循环输出
  def forTest(): Unit = {
    val arr = Array("Java", "Scala")
    for (x <- arr) {
      println(x)
    }
  }

  //合并数组
  def mergeTest(): Unit = {
    val arr = Array("java", "scala")
    val arr1 = Array("go", "python")
    val arr2 = Array.concat(arr, arr1)
    println("merge arr2: " + arr2.view)
    val arr3 = arr.concat(arr1)
    println("merge arr3: " + arr3.view)
  }


}
