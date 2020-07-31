package cn.wllsrx.zoe.repository

import cn.wllsrx.zoe.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


/**
 * @author zoe
 **/
@Repository
trait CustomerRepository extends JpaRepository[Customer, Int] {
  /**
   * 根据用户名查询
   * @param name 姓名
   * @return customer
   */
  def findByCustomerName(name: String): Customer
}
