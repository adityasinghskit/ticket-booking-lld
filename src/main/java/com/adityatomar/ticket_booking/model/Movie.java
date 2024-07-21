package com.adityatomar.ticket_booking.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "movie")
public class Movie {

    @Id
    private String id = UUID.randomUUID().toString();
    @NotNull(message = "Name is mandatory")
    @Indexed(unique = true)
    private String name;

    public Movie(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

}
