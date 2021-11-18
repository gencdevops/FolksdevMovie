package com.example.movie.exception;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(String s) {
        super(s);
    }
}
