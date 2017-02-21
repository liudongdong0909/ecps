package com.ecps.common.exception;

/**
 * 基础异常类，提供异常响应消息和异常响应码，继承自运行时异常，各个业务模块的异常应该继承自该异常
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:08
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 9175004587774103383L;

    public BaseException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
