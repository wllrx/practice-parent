package cn.wllsrx.zoe.exception;

/**
 * 业务异常
 * @author zoe
 **/
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 2546244140708201923L;

    public ServiceException(String message) {
        super(message);
    }
}
