package com.api.movies.models.movie;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieDTO {
    @NotNull
    public Integer id;
    public String title;
    public LocalDate releaseDate;
    public double rating;
}
