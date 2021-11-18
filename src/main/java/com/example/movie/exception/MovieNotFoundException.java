package com.example.movie.exception;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }
}
