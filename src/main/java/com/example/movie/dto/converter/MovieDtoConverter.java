package com.example.movie.dto.converter;


import com.example.movie.Actor;
import com.example.movie.dto.ActorDto;
import com.example.movie.dto.DirectorDto;
import com.example.movie.dto.MovieDto;
import com.example.movie.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.movie.util.MovieDurationTimeUtil.getMovieDurationString;

@Component
public class MovieDtoConverter {

    public MovieDto convert(Movie from) {
        return new MovieDto(
                from.getId(),
                from.getTitle(),
                from.getDescription(),
                from.getImdbUrl(),
                getMovieDurationString(from.getDuration()),
                from.getFeaturedYear(),
                from.getGenresTypes(),
                getActorList(from.getActors().stream().collect(Collectors.toList())),
                new DirectorDto(from.getDirector().getId(),
                        from.getDirector().getName(),
                        from.getDirector().getLastName()),
                from.getPublisher().getName()
        );
    }

    private List<ActorDto> getActorList(List<Actor> actorList) {

        return actorList.stream()
                .map(a -> new ActorDto(
                        a.getId(),
                        a.getName(),
                        a.getDateOfBirth(),
                        a.getGender()))
                .collect(Collectors.toList());
    }
}
