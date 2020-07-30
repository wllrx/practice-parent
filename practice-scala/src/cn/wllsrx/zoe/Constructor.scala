package cn.wllsrx.zoe

/**
 * @author zoe
 *
 * 主构造器和附属构造器
 **/
class Constructor(name :String ,age :Int) {
  //定义属性
  var userName : String = name
  var userAge : Int = age
  var idCard : String = ""

  //附属构造器
  def this(name: String,age : Int,idCard: String){
    this(name,age)
    this.idCard = idCard
  }

}
