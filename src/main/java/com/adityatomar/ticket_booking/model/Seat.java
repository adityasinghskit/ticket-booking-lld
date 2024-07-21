package com.adityatomar.ticket_booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@Document(collection = "seat")
public class Seat {

    @Id
    private String id = UUID.randomUUID().toString();
    private String row;
    private int no;

}
