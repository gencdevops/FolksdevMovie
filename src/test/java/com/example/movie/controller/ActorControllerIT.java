package com.example.movie.controller;


import com.example.movie.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ActorControllerIT extends MovieControllerIT {


    @Test
    public void testGetActorById_whenActorIdExist_shouldReturnActorDto() throws Exception {
        Actor actor = generateActor(100);
        actor = actorRepository.save(actor);

        this.mockMvc.perform(get("/v1/actor/" + actor.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id", is(actor.getId())))
                .andExpect(jsonPath("$.name", is(actor.getName())))
                .andExpect(jsonPath("$.gender", is(actor.getGender().name())))
                .andExpect(jsonPath("$.dateOfBirth", is(actor.getDateOfBirth().toString())));
    }

    @Test
    public void testGetActorById_whenActorIdNotExist_shouldReturnNotFound() throws Exception {

        this.mockMvc.perform(get("/v1/actor/" + "not-exist-id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

}
