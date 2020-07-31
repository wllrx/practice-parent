package cn.wllsrx.zoe.service

import cn.gjing.tools.common.result.PageResult
import cn.wllsrx.zoe.entity.Customer
import cn.wllsrx.zoe.exception.ScalaServiceException
import cn.wllsrx.zoe.repository.CustomerRepository
import javax.annotation.Resource
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * @author zoe
 **/
@Service
class CustomerService @Resource()(customerRepository: CustomerRepository) {

  /**
   * 保存customer
   *
   * @param name 名称
   */
  def saveCustomer(name: String): Unit = {
    var customer = customerRepository.findByCustomerName(name)
    if (customer != null) {
      throw new ScalaServiceException("添加失败,用户已存在")
    }
    customer = new Customer(name)
    customerRepository.save(customer)
  }

  /**
   * 分页查询
   *
   * @param pageable 分页
   * @return customer列表
   */
  def selectCustomer(pageable: Pageable): PageResult[java.util.List[Customer]] = {
    val page = customerRepository.findAll(pageable)
    PageResult.of(page.getContent, page.getTotalPages, page.getSize, page.getTotalElements, page.getNumber)
  }

  /**
   * 更新 customer
   *
   * @param id   id
   * @param name 名称
   */
  def updateCustomer(id: Int, name: String): Unit = {
    val customer = customerRepository.findById(id).orElseThrow(() => new ScalaServiceException("更新失败,用户不存在"))
    customer.setCustomerName(name)
    customerRepository.saveAndFlush(customer)
  }

  /**
   * 删除customer
   *
   * @param id id
   */
  def deleteCustomer(id: Int): Unit = {
    val customer = customerRepository.findById(id).orElseThrow(() => new ScalaServiceException("更新失败,用户不存在"))
    customerRepository.delete(customer)
  }

}
