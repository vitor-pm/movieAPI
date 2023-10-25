package com.api.movies.movies;

import com.api.movies.models.movie.MovieDTO;

import java.time.LocalDate;

public class MovieBuilder {
    public static MovieDTO generate(){
        return new MovieDTO(1, "Movie", LocalDate.now(), 9.0);
    }
}
