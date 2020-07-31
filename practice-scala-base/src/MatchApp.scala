/**
 * @author zoe
 **/
object MatchApp {
  def main(args: Array[String]): Unit = {
    println(mathTest(1))
    println(mathTest1("test"))
    println(mathTest1(6))
    println(mathTest1())
    println(mathTest2(1))
    println(mathTest2("hello"))
    println(mathTest2(2))
    //满足test3第一case
    println(mathTest3(Array(1)))
    //不满足test3第一和第二case
    println(mathTest3(Array(1, 2)))
    //满足test3第二case
    println(mathTest3(Array(2, 3, 4)))
    //满足test3第二个case
    println(mathTest3(Array(2)))
    except()
  }

  //简单案例
  def mathTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  //类型匹配
  def mathTest1(x: Any): Any = x match {
    case x: String => "Scala.String"
    case y: Int => "Scala.Int"
    case _ => "many"
  }

  //条件匹配
  def mathTest2(value: Any): Any = value match {
    case 1 => "输入的是: 1"
    case _ if (value.equals("hello")) => "world"
    case _ => value
  }

  //数组匹配
  def mathTest3(x: Array[Any]): Int = x match {
    case Array(1) => 1
    case Array(2, _*) => 666
    case _ => 0
  }

  //样例类匹配
  //使用了case关键字的类定义就是就是样例类(case class)，样例类是种特殊的类，经过优化以用于模式匹配
  def mathTest4(x: Person1): String = x match {
    case Person1("张三") => "张三"
    case Person1("李四") => "李四"
    case _ => "xx"
  }

  //异常处理
  def except(): Unit = {
    try {
      val i = 10 / 0
      println(i)
    } catch {
      case e: ArithmeticException => println("除数不能为0")
      case e: Exception => println("最大异常")
    } finally {
      //资源释放,和Java类似
    }
  }


}

case class Person1(name: String)