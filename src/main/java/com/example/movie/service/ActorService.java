package com.example.movie.service;

import com.example.movie.Actor;
import com.example.movie.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    protected List<Actor> getActorList(List<String> idList){
        return actorRepository.findAllByIdIn(idList);
    }
}