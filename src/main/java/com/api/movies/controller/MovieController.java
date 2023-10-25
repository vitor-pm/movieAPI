package com.api.movies.controller;

import com.api.movies.models.movie.MovieDTO;
import com.api.movies.service.movie.IMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("movie")
public class MovieController extends BaseController {

    @Autowired
    private IMovieService service;
    
    @GetMapping
    public ResponseEntity<List<MovieDTO>> listAllMovies(){
        return responseOK(service.listAllMovies());
    }

    @PostMapping
    public ResponseEntity<MovieDTO> insertNewMovie(@RequestBody @Valid MovieDTO movie) {
        return responseCreated(service.insertNewMovie(movie));
    }

    @PutMapping
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody @Valid MovieDTO movie){
        return responseOK(service.updateMovie(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Integer id) {
        service.deleteMovie(id);
        return respondeDelete();
    }
}
