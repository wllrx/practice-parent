package cn.wllsrx.zoe

/**
 * @author zoe
 **/
object InterfaceImplementation {
  def main(args: Array[String]): Unit = {
    val man = new Man
    man.say("张三")
    man.eat("苹果")
  }
}

class Man extends User{
  /**
   * 说
   *
   * @param content 内容
   */
  override def say(content: String): Unit = println(content)
}
