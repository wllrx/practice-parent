package cn.wllsrx.zoe

/**
 * @author zoe
 **/
object FunctionPractice {
  def main(args: Array[String]): Unit = {
    println("hello")
    sayHello("world")
    sayWorld()
    nameTest(text1 = "name", text2 = "test")
    varTest(1, 2, 3, 4)
    booleanTest(2, 4)
    whileTest()
    forTest()
    doWhileTest()
  }

  //def 方法名(参数名: 参数类型): 返回值类型 = {//方法体}
  def sayHello(text: String): Unit = {
    println(text)
  }

  //默认值 调用方法时未传参,则会使用默认值
  def sayWorld(text: String = "world2"): Unit = println(text)

  //命名参数 通过参数名指定你当前设置的值是哪一个参数
  def nameTest(text1: String, text2: String): Unit = {
    println(text1, text2)
  }

  //可变参数   不限制参数个数,如Java1.5出现的...
  def varTest(a: Int*): Unit = println(a)

  //条件表达式
  def booleanTest(b: Int, c: Int): Unit = {
    if (b == c) println(true) else println(false)
  }

  //循环表达式
  //在循环时很多时候会用到区间，scala提供了两种方式，分别为to和until, to关键字会包含右边的值，比如1 to 10,此时循环输出会是1-10；until不包含, 循环输出会是1-9

  //while
  def whileTest(): Unit = {
    var d = 0
    while (d < 10) {
      println("Value of d: " + d)
      d = d + 1
    }
  }

  //for
  def forTest(): Unit = {
    //<- 为a赋值为s
    val s = 0
    for (a <- s to 10) {
      println("Value of s: " + a)
    }
    for (a <- s until 10) {
      println("Value of s: " + a)
    }
  }

  //do while
  def doWhileTest(): Unit = {
    var a = 10
    do {
      println("Value of a: " + a)
      a = a + 1
    } while (a < 20)
  }


}
