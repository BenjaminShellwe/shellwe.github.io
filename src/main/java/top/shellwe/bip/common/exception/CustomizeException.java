package top.shellwe.bip.common.exception;

/**
 *  <p> 自定义异常类 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/8/26 15:11
 */
public class CustomizeException extends RuntimeException {

    /**
     * 异常状态码
     */
    private Integer code;

    public CustomizeException(Throwable cause) {
        super(cause);
    }

    public CustomizeException(String message) {
        super(message);
    }

    public CustomizeException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }

}
