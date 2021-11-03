package com.example.movie.repository;


import com.example.movie.Actor;
import com.example.movie.model.Director;
import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
                             APPLICATION CONTEXT
 * |                 |
 * | MovieRepository | =>
 * | MovieRepository | =>
 * | MovieRepository | =>
 * | MovieRepository | =>
 * ___________________
 */

public interface MovieRepository extends JpaRepository<Movie, String>,
        /*Ornek olmasi icin var*/CustomMovieRepository{

    //SELECT * FROM Movie WHERE title={mahmut}
    Movie findByTitle(String mahmut);

    //SELECT * FROM Movie WHERE title = {title} AND description LIKE '%description%'
    Movie findByTitleAndDescriptionIsLike(String title, String description);

    //SELECT * FROM Movie WHERE duration < {duration}
    Movie findByDurationLessThan(Integer duration);

    @Query(value = "select m.imdbUrl from Movie m where m.id=?1")
    Optional<String> selectImdbUrlByMovieId(String id);


}
