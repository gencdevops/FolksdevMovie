package com.example.movie;

import com.example.movie.repository.ActorRepository;
import com.example.movie.repository.DirectorRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.PublisherRepository;
import com.example.movie.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Context ayaga kaldirir
@TestPropertySource(locations = "classpath:application.properties") // Test context icin kullanilacak propertyleri ayarlar.
@DirtiesContext
@AutoConfigureMockMvc // Context icerisindeki servletleri ayaga kaldirir.
public class IntegrationTestSupport<MovieDtoConverter> {

    @Autowired
    public MovieService movieService;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ActorRepository actorRepository;

    @Autowired
    public PublisherRepository publisherRepository;

    @Autowired
    public DirectorRepository directorRepository;

    @Autowired
    public MovieDtoConverter movieDtoConverter;

    public final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    }

    public List<Actor> generateActors(int size){
        return IntStream.range(0, size)
                .mapToObj( this::generateActor)
                .collect(Collectors.toList());
    }

    public Actor generateActor(int i){
        return new Actor("actor-name-"+i, LocalDate.of(1999, 12, 30), Gender.MALE);
    }
//test

}
