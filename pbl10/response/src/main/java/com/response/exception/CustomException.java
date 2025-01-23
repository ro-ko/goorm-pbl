package com.response.exception;

import lombok.Getter;
import org.springframework.util.StringUtils;

public class CustomException extends RuntimeException{

    @Getter
    private ErrorCode errorCode;
    private String message;

    @Getter
    private Object data;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public CustomException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        if(StringUtils.hasLength(this.message)) {
            return this.message;
        }
        return errorCode.getMessage();
    }
}
