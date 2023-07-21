package com.api.movies.service.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.movies.models.movie.Movie;
import com.api.movies.repository.MovieRepository;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    @Override
    public Movie insertNewMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        repository.deleteById(id);
    }

}
