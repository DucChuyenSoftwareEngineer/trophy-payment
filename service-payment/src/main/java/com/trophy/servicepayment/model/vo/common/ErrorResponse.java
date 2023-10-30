package com.trophy.servicepayment.model.vo.common;



public class ErrorResponse {
    private Integer code;
    private String message;

    public ErrorResponse() {

    }

    public ErrorResponse code(Integer code) {
        this.code = code;
        return this;
    }

    public ErrorResponse message(String errorMessage) {
        this.message=errorMessage;
        return this;
    }
}
