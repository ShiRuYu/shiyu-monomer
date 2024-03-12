package com.shiyu.utils.exception;

import lombok.Getter;

/**
 * @ClassName: BusinessException
 * @Description: 自定义业务异常
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int errorCode = 500;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

}
