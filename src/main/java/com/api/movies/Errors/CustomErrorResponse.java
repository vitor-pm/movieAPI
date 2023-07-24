package com.api.movies.Errors;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
