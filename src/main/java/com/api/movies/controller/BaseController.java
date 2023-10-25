package com.api.movies.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class BaseController {
    public <T> ResponseEntity<T> response(T body, HttpStatus statusCode){
        return ResponseEntity.status(statusCode).body(body);
    }

    public <T> ResponseEntity<T> responseCreated(T body){
        return response(body, HttpStatus.CREATED);
    }

    public <T> ResponseEntity<T> responseOK(T body){
        return response(body, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> respondeDelete(){
        return response(null, HttpStatus.NO_CONTENT);
    }
}
