package com.example.movie.dto.converter;

import com.example.movie.Actor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.folksdev.movie.util.MovieDurationTimeUtil.getMovieDurationString;

@Component
public class ActorDtoConverter {

    public ActorDto convert(Actor from) {
        return new ActorDto(
                from.getId(),
                from.getName(),
                from.getDateOfBirth(),
                from.getGender(),
                getMovieList(from.getMovies().stream().collect(Collectors.toList()))
        );
    }

    private List<MovieDto> getMovieList(List<Movie> movies) {
        return movies.stream()
                .map(m -> new MovieDto(
                        m.getId(),
                        m.getTitle(),
                        m.getDescription(),
                        m.getImdbUrl(),
                        getMovieDurationString(m.getDuration()),
                        m.getFeaturedYear(),
                        m.getGenresTypes()))
                .collect(Collectors.toList());
    }
}
