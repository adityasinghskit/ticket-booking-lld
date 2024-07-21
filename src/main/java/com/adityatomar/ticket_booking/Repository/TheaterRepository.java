package com.adityatomar.ticket_booking.Repository;

import com.adityatomar.ticket_booking.model.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TheaterRepository extends MongoRepository<Theater, String> {
    Optional<Theater> findByName(String name);
    Optional<Theater> findById(String id);
}
