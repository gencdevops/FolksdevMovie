package com.example.movie.repository;

import java.util.Optional;

public interface CustomMovieRepository {

    Optional<String> findImdbUrlByMovieId(String id);

}