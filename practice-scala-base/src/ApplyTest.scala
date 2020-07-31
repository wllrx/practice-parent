/**
 * @author zoe
 **/
//如果有一个class和一个同名的object，那么就称这个object是class的伴生对象，class是object的伴生类
class ApplyTest {
  def apply():Unit={
    println("Executor class apply...")
  }

}

object ApplyTest{
  //最佳实践，在object的apply方法去new class
  def apply(): ApplyTest ={
    println("Executor object apply...")
    new ApplyTest()
  }
}

object Test3{
  def main(args: Array[String]): Unit = {
    //直接通过类名加括号  是调用object中的apply方法
    val test = ApplyTest()
    // 对象加括号，是调用class中的apply方法
    test()
  }
}
