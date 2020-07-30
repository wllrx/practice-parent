package cn.wllsrx.zoe


/**
 * @author zoe
 **/
object MapApp {
  def main(args: Array[String]): Unit = {
    mapTest()
    baseMap()
    mergeTest()
    containsTest()
  }

  /**
   * 创建map
   */
  def mapTest(): Unit = {
    //空map
    val m = Map()
    //存在键值对
    var m1 = Map("名字" -> "张三", "年龄" -> 12)
    println(m1.mkString(","))
    //加一个新的键值对
    m1 += ("性别" -> "男")
    //加一个map
    m1 ++= Map("省份" -> "厦门", "民族" -> "汉")
    println(m1.mkString(","))
    //根据key获取value
    println(m1.get("省份"))
    //根据key删除键值对
    m1 -= "年龄"
    println(m1.mkString(","))
    //删除多个键值对
    m1 --= List("省份", "民族")
    println(m1.mkString(","))
  }

  //基本操作
  def baseMap(): Unit = {
    val m = Map("名字" -> "张三", "年龄" -> 12)
    //返回所有的key
    println(m.keys)
    //返回所有的value
    println(m.values)
    //判断是否为空
    println(m.isEmpty)
  }

  //合并
  //使用 ++ 运算符或 Map.++() 方法来连接两个 Map，Map 合并时会移除重复的 key
  def mergeTest(): Unit = {
    val map = Map("年龄" -> 20)
    val map1 = Map("姓名" -> "李四", "年龄" -> 22)
    println(map ++ map1)
    println(map.++(map1))
  }

  //查看Map中是否存在指定的key
  def containsTest(): Unit = {
    val map = Map("姓名" -> "王五", "年龄" -> 25)
    println(map.contains("姓名"))
  }


}
