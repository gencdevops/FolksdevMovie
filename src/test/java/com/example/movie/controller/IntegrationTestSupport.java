package com.example.movie.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Context ayaga kaldirir
@TestPropertySource(locations = "classpath:application.properties") // Test context icin kullanilacak propertyleri ayarlar.
@DirtiesContext
@AutoConfigureMockMvc // Context icerisindeki servletleri ayaga kaldirir.
public class IntegrationTestSupport {

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
}
