package com.api.movies.models.person;

import com.api.movies.enums.GenderEnum;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDTO {
    private Long id;
    @NotNull
    private String name;
    private String biography;
    private GenderEnum gender;
    private LocalDate birthDate;
    private String nacionality;
}
