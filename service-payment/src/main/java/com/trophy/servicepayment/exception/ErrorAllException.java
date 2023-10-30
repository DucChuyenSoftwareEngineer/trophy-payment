package com.trophy.servicepayment.exception;


import com.trophy.servicepayment.model.resultcode.BaseCode;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ErrorAllException extends Exception {

    private BaseCode errorCode;

    public ErrorAllException(BaseCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    public Integer getCode() {
        return errorCode.getCode();
    }

    public String getErrorMessage() {
        return errorCode.getMessage();
    }
}
