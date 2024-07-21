package com.adityatomar.ticket_booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Document(collection = "screen")
public class Screen {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private Theater theater;
    private int capacity;
    private int rows;
    private List<Seat> seats;

    public Screen(String name, int capacity, int rows, Theater theater){
        this.name = name;
        this.capacity = capacity;
        this.rows = rows;
        this.theater = theater;
        this.seats = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }
}
