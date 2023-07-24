package com.api.movies.Exceptions;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    private HttpStatus status;

    public BaseException(HttpStatus status, String message){
        super(message);
        setStatus(status);
    }

    public void setStatus(HttpStatus status){
        this.status = status;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
    
}
