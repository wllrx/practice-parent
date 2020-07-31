/**
 * @author zoe
 **/
class Son(name: String, age: Int, val city: String) extends Constructor(name, age) {

  //重写
  override def toString: String = s"Son($name,$age,$city)"
}
object Test2{
  def main(args: Array[String]): Unit = {
    val son = new Son("张三",20,"厦门")
    println(son.city)
    println(son.userAge)
    println(son.userName)
  }

}
