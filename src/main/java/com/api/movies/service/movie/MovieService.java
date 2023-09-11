package com.api.movies.service.movie;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.movies.models.movie.Movie;
import com.api.movies.models.movie.MovieDTO;
import com.api.movies.service.AbstractService;

@Service
public class MovieService extends AbstractService<Movie, MovieDTO, Integer> implements IMovieService {

    @Override
    public Movie convertToEntity(MovieDTO model) {
        return modelMapper.map(model, Movie.class);
    }

    @Override
    public MovieDTO convertToModel(Movie entity) {
        return modelMapper.map(entity, MovieDTO.class);
    }

    @Override
    public MovieDTO insertNewMovie(MovieDTO movie) {
        return insert(movie);
    }

    @Override
    public List<MovieDTO> listAllMovies() {
        return listAll();
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movie) {
        return update(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        deleteById(id);
    }
}
