package com.example.movie.repository;

import com.example.movie.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, String> {
    List<Actor> findAllByIdIn(List<String> idList);

}
