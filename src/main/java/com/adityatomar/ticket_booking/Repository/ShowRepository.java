package com.adityatomar.ticket_booking.Repository;

import com.adityatomar.ticket_booking.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, String> {
}
