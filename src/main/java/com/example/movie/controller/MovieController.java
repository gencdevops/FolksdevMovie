package com.example.movie.controller;

import com.example.movie.dto.CreateMovieRequest;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieRequest movieRequest){
        return ResponseEntity.ok(movieService.createMovie(movieRequest));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}