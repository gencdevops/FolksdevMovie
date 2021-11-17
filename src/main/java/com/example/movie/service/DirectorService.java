package com.example.movie.service;

import com.example.movie.model.Director;
import com.example.movie.repository.DirectorRepository;
import org.springframework.stereotype.Service;

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
