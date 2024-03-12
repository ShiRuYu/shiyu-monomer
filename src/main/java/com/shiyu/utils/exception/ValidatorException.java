package com.shiyu.utils.exception;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ValidatorException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = 1L;

    private int errorCode = 406;

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ValidatorException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
