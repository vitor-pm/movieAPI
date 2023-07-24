package com.api.movies.service.movie;

import java.util.List;

import com.api.movies.models.movie.MovieDTO;

public interface IMovieService {
    public List<MovieDTO> listAllMovies();

    public MovieDTO insertNewMovie(MovieDTO movie);

    public MovieDTO updateMovie(MovieDTO movie);

    public void deleteMovie(Integer id);
}
