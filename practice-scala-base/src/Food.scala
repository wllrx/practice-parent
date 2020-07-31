/**
 * @author zoe
 **/
//抽象类
abstract class Food {
  def name():Unit
}
class Apple extends Food{
  override def name(): Unit ={
    println("Apple")
  }
}

