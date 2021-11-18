package com.example.movie.service;

import com.example.movie.model.Publisher;
import com.example.movie.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@@Service
public class PublisherService {

    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    protected Publisher getPublisherById(String id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Publisher not found with id " + id);
                    return new PublisherNotFoundException("Publisher not found id: " + id );
                });
    }
}
