package com.api.movies.models.movie;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    public Integer id;
    public String title;
    public LocalDate releaseDate;
    public double rating;
}
