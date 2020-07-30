package cn.wllsrx.zoe

import scala.collection.mutable.ListBuffer

/**
 * @author zoe
 **/
object ListApp {
  def main(args: Array[String]): Unit = {
    bufferList()
    baseList()
    mkList()
    reverseTest()
    fillTest()
  }

  /**
   * List
   *
   * List的特征是其元素以线性方式存储，集合中可以存放重复对象。
   */

  /**
   * 创建list
   */
  //定长list
  //构造列表的两个基本单位是 Nil 和 ::
  //Nil 也可以表示为一个空列表。
  def makeList(): Unit = {
    //数字列表
    var l1 = List(1, 2, 3, 4)
    var l2 = 1 :: 2 :: 3 :: Nil
    //生成空列表
    var l3 = Nil
  }

  def bufferList(): Unit = {
    val l = ListBuffer[Int]()
    //加一个元素
    l += 2
    //加多个元素
    l += (3, 4)
    //加入一个集合
    l ++= List(5, 6)
    //打印
    println(l.mkString(","))
  }

  /**
   * 列表操作
   */

  //基本操作(返回第一个元素、返回第一个元素以外的列表、判断列表是否为空)
  def baseList(): Unit = {
    val r = List(1, 2, 3)
    //打印第一个元素1
    println(r.head)
    //打印除第一个元素外的所有元素2,3
    println(r.tail)
    //判断列表是否为空 false
    println(r.isEmpty)
  }

  //拼接
  def mkList(): Unit = {
    val l1 = List(1, 2, 3)
    val l2 = List(3, 4)
    val l3 = l1 ::: l2
    //较第一种后者加进去后在列表前面
    val l4 = l1.:::(l2)
    val l5 = List.concat(l1,l2)
    println("l3: "+l3.mkString(","))
    println("l4: "+l4.mkString(","))
    println("l5: "+l5.mkString(","))
  }

  //列表反转
  def reverseTest(): Unit ={
    val l = List(1,2,3)
    //打印3,2,1
    println(l.reverse.mkString(","))
  }

  //创建一个指定重复数量的元素列表
  def fillTest(): Unit ={
    //元素重复个数3  重复元素1
    val l = List.fill(3)(1)
    println(l.mkString(","))
  }



}
