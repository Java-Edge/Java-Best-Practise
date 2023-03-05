package com.javaedge.exception.predefinedexception;

public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
