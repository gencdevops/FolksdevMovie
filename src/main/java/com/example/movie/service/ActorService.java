package com.example.movie.service;

import com.example.movie.Actor;
import com.example.movie.Gender;
import com.example.movie.dto.ActorDto;
import com.example.movie.dto.converter.ActorDtoConverter;
import com.example.movie.exception.ActorNotFoundException;
import com.example.movie.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorDtoConverter actorDtoConverter;

    public ActorService(ActorRepository actorRepository, ActorDtoConverter actorDtoConverter) {
        this.actorRepository = actorRepository;
        this.actorDtoConverter = actorDtoConverter;
    }

    public List<ActorDto> getAllActors() {
        return actorRepository.findAll()
                .stream()
                .map(actorDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public ActorDto getActorById(String id) {
        return actorDtoConverter.convert(actorRepository.findById(id)
                .orElseThrow(() ->
                        new ActorNotFoundException("Actor could not found with id " + id)));
    }

    protected List<Actor> getActorList(List<String> idList) {
        return Optional.of(actorRepository.findAllByIdIn(idList))
                .filter(a -> !a.isEmpty())
                .orElse(List.of(
                        new Actor("id",
                                "taner",
                                LocalDate.of(1997, 04, 23),
                                Gender.MALE)
                ));
    }


}