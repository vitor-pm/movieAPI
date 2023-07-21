package com.api.movies.controller;

import com.api.movies.models.movie.Movie;
import com.api.movies.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private IMovieService service;
    
    @GetMapping
    public List<Movie> listAllMovies(){
        return service.findAllMovies();
    }

    @PostMapping
    public Movie insertNewMovie(@RequestBody Movie movie){
        return service.insertNewMovie(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie){
        return service.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Integer id){
        service.deleteMovie(id);
    }
}
