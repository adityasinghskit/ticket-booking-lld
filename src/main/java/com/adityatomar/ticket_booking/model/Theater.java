package com.adityatomar.ticket_booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Document(collection = "theater")
public class Theater {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private List<Screen> screens;

    public Theater(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.screens = new ArrayList<>();
    }
}
