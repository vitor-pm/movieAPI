package com.api.movies.controllerAdvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.movies.Exceptions.BaseException;
import com.api.movies.Exceptions.CustomErrorResponse;

@ControllerAdvice
public class BaseExcpetionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<CustomErrorResponse> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new CustomErrorResponse(ex.getMessage(), ex.getStatus().value()));
    }

}
