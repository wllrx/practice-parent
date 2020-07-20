package cn.wllsrx.zoe.exception;

/**
 * 业务异常
 * @author zoe
 **/
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
