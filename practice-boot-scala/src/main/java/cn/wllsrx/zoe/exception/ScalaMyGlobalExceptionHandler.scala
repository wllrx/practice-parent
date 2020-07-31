package cn.wllsrx.zoe.exception

import cn.gjing.tools.common.result.ErrorResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{ExceptionHandler, RestControllerAdvice}

/**
 * @author zoe
 **/
@RestControllerAdvice
class ScalaMyGlobalExceptionHandler {

  @ExceptionHandler(Array(classOf[ScalaServiceException]))
  def mx(scalaServiceException: ScalaServiceException): ResponseEntity[ErrorResult]={
    ResponseEntity.badRequest().body(ErrorResult.failure(scalaServiceException.getMessage))
  }

  @ExceptionHandler(Array(classOf[Exception]))
  def ex(exception: Exception):  ResponseEntity[ErrorResult] = {
    exception.printStackTrace()
    ResponseEntity.badRequest().body(ErrorResult.failure("操作失败"))
  }
}
