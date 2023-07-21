package com.api.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.movies.models.movie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
