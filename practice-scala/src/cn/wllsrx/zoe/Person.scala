package cn.wllsrx.zoe

/**
 * @author zoe
 **/
//类是对象的抽象，而对象是类的具体实例。类是抽象的，不占用内存，而对象是具体的，占用存储空间
class Person {
  // 定义属性，Scala会自动帮var类型的属性生成get、set，val类型的属性生成get
  var name = ""
  val age = 10
  // 可通过下划线作为一个占坑符，使用占位符时就不允许使用val了
  var idCard: String = _

  def eat(): Unit ={
    println(name + "吃饭~~~~~~~~")
  }

}
object Test{
  def main(args: Array[String]): Unit = {
    val person = new Person()
    person.name = "张三"
    person.idCard="1234560"
    person.eat()
    println(person.idCard)
  }
}
