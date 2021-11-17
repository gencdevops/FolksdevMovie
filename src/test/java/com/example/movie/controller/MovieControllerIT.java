package com.example.movie.controller;

import com.example.movie.Actor;
import com.example.movie.IntegrationTestSupport;
import com.example.movie.dto.CreateMovieRequest;
import com.example.movie.model.Director;
import com.example.movie.model.GenresType;
import com.example.movie.model.Movie;
import com.example.movie.model.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
        import static org.junit.jupiter.api.Assertions.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MovieControllerIT extends IntegrationTestSupport {

    @Test
    public void testCreateMovie_whenCreateMovieRequestIsValid_shouldCreateMovieAndReturnMovieDto() throws Exception {
        Publisher publisher = publisherRepository.save(new Publisher("publisher-name"));
        Director director = directorRepository.save(new Director("director-name", "director-lastName"));
        List<Actor> actors = actorRepository.saveAll(generateActors(3));
        CreateMovieRequest request = new CreateMovieRequest(
                "title",
                "description",
                "imdbUrl",
                125,
                2000,
                List.of(GenresType.ACTION, GenresType.COMEDY),
                actors.stream().map(Actor::getId).collect(Collectors.toList()),
                publisher.getId(),
                director.getId()
        );

        this.mockMvc.perform(post("/v1/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(request)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("title")))
                .andExpect(jsonPath("$.description", is("description")))
                .andExpect(jsonPath("$.actors", hasSize(3))) //array Object
                .andExpect(jsonPath("$.director.name", is("director-name")))
                .andExpect(jsonPath("$.duration", is("2h 5m")));

        List<Movie> createdMovie = movieRepository.findAll();
        assertEquals(1, createdMovie.size());

    }

    @Test
    public void testCreateMovie_whenCreateMovieRequestIsInvalid_shouldNotCreateMovieAndReturn400BadRequest() throws Exception {
        CreateMovieRequest request = new CreateMovieRequest(
                "",
                "",
                "",
                -125,
                1800,
                Collections.emptyList(),
                Collections.emptyList(),
                "",
                ""
        );

        this.mockMvc.perform(post("/v1/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.duration", notNullValue()))
                .andExpect(jsonPath("$.genresType", notNullValue()))
                .andExpect(jsonPath("$.publisherId", is("publisher id bos olamaz")))
                .andExpect(jsonPath("$.directorId", notNullValue()))
                .andExpect(jsonPath("$.featuredYear", notNullValue()))
                .andExpect(jsonPath("$.description", notNullValue()))
                .andExpect(jsonPath("$.title", notNullValue()))
                .andExpect(jsonPath("$.actorIds", notNullValue()));

        List<Movie> createdMovie = movieRepository.findAll();
        assertEquals(0, createdMovie.size());

    }

}