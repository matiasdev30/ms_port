package com.ms_user.users.exceptions;

import org.springframework.http.HttpStatus;

public class ResponseModelError {
    
    private String msg;
    private HttpStatus httpStatus;

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public String getMsg() {
        return msg;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    

}
