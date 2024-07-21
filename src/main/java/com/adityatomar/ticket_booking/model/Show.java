package com.adityatomar.ticket_booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "show")
public class Show {
    @Id
    private String id = UUID.randomUUID().toString();
    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private int timeInMinutes;

}
