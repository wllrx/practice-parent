package cn.wllsrx.zoe.exception;


import cn.gjing.tools.common.exception.ParamValidException;
import cn.gjing.tools.common.result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;

/**
 * @author zoe
 **/
@RestControllerAdvice
public class PracticeExceptionHandler {

    /**
     * 业务异常
     *
     * @param s ServiceException
     * @return ErrorResult
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResult> se(ServiceException s) {
        return ResponseEntity.badRequest().body(ErrorResult.failure(HttpStatus.BAD_REQUEST.value(), s.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> ex(Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(ErrorResult.failure(HttpStatus.BAD_REQUEST.value(), "操作失败，请联系管理员"));
    }

    @ExceptionHandler(ParamValidException.class)
    public ResponseEntity<ErrorResult> pa(ParamValidException s) {
        return ResponseEntity.badRequest().body(ErrorResult.failure(HttpStatus.BAD_REQUEST.value(), s.getMessage()));
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResult> au(AuthException s) {
        return ResponseEntity.badRequest().body(ErrorResult.failure(HttpStatus.BAD_REQUEST.value(), s.getMessage()));
    }

}
