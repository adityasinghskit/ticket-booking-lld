package com.adityatomar.ticket_booking.Repository;

import com.adityatomar.ticket_booking.model.Screen;
import com.adityatomar.ticket_booking.model.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ScreenRepository extends MongoRepository<Screen, String> {

    Optional<Screen> findByName(String name);
}
