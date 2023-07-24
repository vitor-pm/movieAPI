package com.api.movies.controllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.movies.Errors.CustomErrorResponse;
import com.api.movies.Errors.ValidationErrorResponse;
import com.api.movies.Exceptions.BaseException;

@ControllerAdvice
public class BaseExcpetionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<CustomErrorResponse> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new CustomErrorResponse(ex.getMessage(), ex.getStatus().value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValdiationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(err -> String.join(" : ", err.getField(), err.getDefaultMessage())).collect(Collectors.toList());

        return ResponseEntity.status(400).body(new ValidationErrorResponse(errors));
    }

}
