package com.example.movie.controller;

import com.example.movie.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable String id) {
        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<List<ActorDto>> filterActorsByName(@PathVariable String name) {
        return ResponseEntity.ok(actorService.getAllActors());
    }

}

