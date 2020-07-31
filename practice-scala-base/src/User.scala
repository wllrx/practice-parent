/**
 * @author zoe
 *
 * Scala Trait(特征) 相当于 Java 的接口，实际上它比接口还功能强大。与接口不同的是，它还可以定义属性和方法的实现。
 * 一般情况下Scala的类只能够继承单一父类，
 * 但是如果是 Trait(特征) 的话就可以继承多个，从结果来看就是实现了多重继承
 **/
trait User {

  //下面定义了两个方法，say()方法没有定义实现，eat()方法定义了方法的默认实现，子类只需实现say()方法即可，
  // 从这里可以看出，Scala中的Trait其实更像Java中的抽象类
  /**
   * 说
   *
   * @param content 内容
   */
  def say(content: String): Unit

  /**
   * 吃
   *
   * @param food 食物
   */
  def eat(food: String): Unit = say("在吃" + food)

}
