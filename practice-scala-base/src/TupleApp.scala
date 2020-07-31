/**
 * @author zoe
 **/
object TupleApp {

  def main(args: Array[String]): Unit = {
    tupleTest()
    obtainTuple()
    iteratorTest()
    tupleToString()
  }

  //定义元组
  //元组的实际类型取决于它的元素的类型，比如 (99, "run") 是 Tuple2[Int, String],
  //目前 Scala 支持的元组最大长度为 22。对于更大长度你可以使用集合，或者扩展元组
  def tupleTest(): Unit = {
    val l1 = (1, "啊", 1.1, true)
    val l2 = new Tuple3[Any, Any, Any](1, "三", 1.1)
    val l3 = Tuple3(1, "三", 1.1)
    println(l1)
    println(l2)
    println(l3)
  }

  //访问元组
  def obtainTuple(): Unit = {
    val t = (1, "的", 1.1)
    //获取第一个元素
    println(t._1)
    //获取第二个元素
    println(t._2)
  }

  //元组的迭代
  def iteratorTest(): Unit ={
    val t = (1, "的", 1.1)
    t.productIterator.foreach(e => println(e))
  }

  //元组转字符串
  def tupleToString(): Unit ={
    val t = (1, "的", 1.1)
    println(t.toString())
  }


}
