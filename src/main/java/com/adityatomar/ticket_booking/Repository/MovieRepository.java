package com.adityatomar.ticket_booking.Repository;

import com.adityatomar.ticket_booking.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Optional<Movie> findByName(String name);
}
