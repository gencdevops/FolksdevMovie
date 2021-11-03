package com.example.movie.repository;


import com.example.movie.Actor;
import com.example.movie.model.Director;
import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, String> {

    Movie findByTitle(String title);

    //SELECT * FROM Movie Where title = {title} AND description LIKE '%description%'
    Movie findByTitleAndDescriptionIsLike(String title, String description);


    Movie findByActorsInAndDirector(Set<Actor> actorList, Director director);

    Movie findByDurationGreaterThan(Integer duration);

    Movie findByIdOrderByDurationAsc();


}
