package com.api.movies.service.movie;

import java.util.List;

import com.api.movies.models.movie.Movie;

public interface IMovieService {
    public List<Movie> findAllMovies();

    public Movie insertNewMovie(Movie movie);

    public Movie updateMovie(Movie movie);

    public void deleteMovie(Integer id);
}
