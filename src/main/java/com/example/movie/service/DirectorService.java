package com.example.movie.service;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    protected Director findDirectorById(String id){
        return directorRepository.findById(id).orElseThrow(() -> new RuntimeException("asd"));
    }
}
