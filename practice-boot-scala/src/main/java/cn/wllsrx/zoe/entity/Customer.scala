package cn.wllsrx.zoe.entity

import javax.persistence._

import scala.beans.BeanProperty

/**
 * @author zoe
 **/
@Entity
@Table(name = "scala_customer")
class Customer {
  //@BeanProperty注解生成get set 方法
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Int = _

  @BeanProperty
  var customerName: String = _

  def this(customerName: String) {
    this()
    this.customerName = customerName
  }

  override def toString = s"Customer($id, $customerName)"
}
