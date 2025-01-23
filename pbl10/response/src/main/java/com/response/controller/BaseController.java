package com.response.controller;


import com.response.ApiResponse;
import com.response.exception.CustomException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

abstract public class BaseController {

    @ExceptionHandler(ClassCastException.class)
    public <t> ApiResponse<t> customExceptionHandler(HttpServletResponse response, CustomException customException) {
        response.setStatus(customException.getErrorCode().getHttpStatus().value());

        return new ApiResponse<t>(
                customException.getErrorCode().getCode(),
                customException.getMessage(),
                customException.getData()
        );
    }

    public <T> ApiResponse<T> makeApiResponse(T result) {
        return new ApiResponse<>(result);
    }

    public <T> ApiResponse<T> makeApiResponse(List<T> results) {
        return new ApiResponse<>(results);
    }
}
