package com.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.response.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
public class ApiResponse<T> {

    private Status status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Metadata metadata;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<T> results;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    public ApiResponse(List<T> results){
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new Metadata(results.size());
        this.results = results;
    }

    public ApiResponse(T result) {
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new Metadata(1);
        this.results = List.of(result);
    }

    public ApiResponse(int code, String message) {
        this.status = new Status(code, message);
    }

    public ApiResponse(int code, String message, Object data) {
        this.status = new Status(code, message);
        this.data = data;
    }

    @Getter
    @AllArgsConstructor
    private static class Status {
        private int code;
        private String message;
    }

    @Getter
    @AllArgsConstructor
    private static class Metadata{
        private int resultCount = 0;
    }
}
