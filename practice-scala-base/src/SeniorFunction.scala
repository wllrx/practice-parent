/**
 * @author zoe
 **/
object SeniorFunction {
  def main(args: Array[String]): Unit = {
    multipleLinesString()
    formatString()
    anonymous()
    higherOrderFunction()
  }

  //多行字符串
  def multipleLinesString(): Unit = {
    val s =
      """
        |这是一个多行字符串
        |这是一个多行字符串
        |""".stripMargin
    println(s)
  }

  //创建格式化字符串
  //String 类中你可以使用 printf() 方法来格式化字符串并输出，String format() 方法可以返回 String 对象而不是 PrintStream 对象
  def formatString(): Unit = {
    val age = 10
    val name = "张三"
    //第一种方式
    println(s"姓名: $name，年龄: $age")
    //第二种方式
    printf("姓名: %s ,年龄: %d", name, age)
    println()
  }

  //匿名函数
  //Scala 中定义匿名函数的语法很简单，箭头左边是参数列表，右边是函数体
  def anonymous(): Unit = {
    val add = (value: Int) => value + 1
    val sub = (a : Int,b: Int) => a*b
    println(add(1))
    println(sub(1,2))
  }

  //高阶函数
  //高阶函数（Higher-Order Function）就是操作其他函数的函数。Scala 中允许使用高阶函数, 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果
  def higherOrderFunction(): Unit ={
    val l = List(1,2,3,4)
    l.map(x => x+1).foreach(println(_))
    l.map(_+1).foreach(println(_))
  }



}
