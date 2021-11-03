package com.example.movie;

import com.example.movie.model.Director;
import com.example.movie.model.GenresType;
import com.example.movie.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MovieApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Director director =  new Director("Mahmut", "Tuncer");
        Movie movie = new Movie("Game of Thrones",
                "Ejderhalarin annesi",
                "imdb/got",
                120,
                2012,
                Arrays.asList(GenresType.FANTASY),
                Collections.emptySet(),
                director, null);

        Movie movie2 = new Movie("Game of Thrones",
                "Ejderhalarin annesi",
                "imdb/got",
                120,
                2012,
                Arrays.asList(GenresType.FANTASY),
                Collections.emptySet(),
                director, null);
        director.getMovies().add(movie);
        director.getMovies().add(movie2);
    }
}
