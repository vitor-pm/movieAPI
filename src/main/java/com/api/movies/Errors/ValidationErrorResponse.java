package com.api.movies.Errors;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class ValidationErrorResponse extends CustomErrorResponse {
    private List<String> errors;

    public ValidationErrorResponse(String message, Integer status, List<String> errors){
        this.setMessage(message);
        this.setStatus(status);
        this.setErrors(errors);
        this.setTime(LocalDateTime.now());
    }

    public ValidationErrorResponse(List<String> errors){
        this.setMessage("Erro na validação dos campos");
        this.setStatus(400);
        this.setErrors(errors);
        this.setTime(LocalDateTime.now());
    }
}