package cn.wllsrx.zoe.controller

import cn.gjing.tools.common.result.PageResult
import cn.gjing.tools.common.valid.NotEmpty
import cn.wllsrx.zoe.entity.Customer
import cn.wllsrx.zoe.service.CustomerService
import io.swagger.annotations.{Api, ApiImplicitParam, ApiImplicitParams, ApiOperation}
import javax.annotation.Resource
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PostMapping, PutMapping, RestController}

/**
 * @author zoe
 **/
@RestController
@Api(tags = Array("customer相关接口"))
class CustomerController @Resource()(customerService: CustomerService) {

  @PostMapping(Array("/customer"))
  @ApiOperation("添加客户")
  @ApiImplicitParam(name = "customerName", value = "用户名", dataType = "String", required = true, paramType = "query")
  @NotEmpty
  def saveCustomer(customerName: String): ResponseEntity[String] = {
    customerService.saveCustomer(customerName)
    ResponseEntity.ok("添加成功")
  }

  @GetMapping(Array("/customer_page"))
  @ApiOperation("分页查询")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int", paramType = "query"),
    new ApiImplicitParam(name = "size", value = "条数", required = true, dataType = "int", paramType = "query"),
  ))
  def pageCustomer(page: Int, size: Int): ResponseEntity[PageResult[java.util.List[Customer]]] = {
    ResponseEntity.ok(customerService.selectCustomer(PageRequest.of(page, size)))
  }

  @NotEmpty
  @PutMapping(Array("/customer"))
  @ApiOperation("更新客户")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "query"),
    new ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query")
  ))
  def updateCustomer(id: Int, name: String): ResponseEntity[String] = {
    customerService.updateCustomer(id, name)
    ResponseEntity.ok("修改成功")
  }

  @DeleteMapping(Array("/customer/{id}"))
  @ApiOperation("删除客户")
  def deleteCustomer(id: Int): ResponseEntity[String] = {
    customerService.deleteCustomer(id)
    ResponseEntity.ok("删除成功")
  }
}
