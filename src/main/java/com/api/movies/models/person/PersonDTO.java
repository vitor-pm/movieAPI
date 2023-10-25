package com.api.movies.models.person;

import com.api.movies.enums.GenderEnum;

import com.api.movies.models.occupation.OccupationDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PersonDTO {
    private Long id;
    @NotNull
    private String name;
    private String biography;
    private GenderEnum gender;
    private LocalDate birthDate;
    private String nacionality;
    private Set<OccupationDTO> occupations;
}
