package cn.wllsrx.zoe

/**
 * @author zoe
 **/
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello world")
    //声明变量 可修改
    var a: String = "Foo"
    //声明常量  不可修改
    val c: String = "Foo"
    var age: Int = 10
    val name: String = "practice"
    //不声明变量类型必须初始化值进行类型推断,否则报错
    var b = 10
    //声明多个变量
    var m, n = 100

  }


}
