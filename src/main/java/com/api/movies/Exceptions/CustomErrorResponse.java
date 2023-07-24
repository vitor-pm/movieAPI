package com.api.movies.Exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorResponse {
    private String message;
    private Integer status;
    private LocalDateTime time;

    public CustomErrorResponse(String message, Integer status){
        this.setMessage(message);
        this.setStatus(status);
        this.setTime(LocalDateTime.now());
    }
  
}
