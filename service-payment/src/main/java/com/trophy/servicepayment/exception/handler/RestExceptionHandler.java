package com.trophy.servicepayment.exception.handler;


import com.trophy.servicepayment.exception.ErrorAllException;
import com.trophy.servicepayment.model.vo.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ErrorAllException.class)
    public ResponseEntity<ErrorResponse> apiException(ErrorAllException exc, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.BAD_REQUEST);
    }
}
