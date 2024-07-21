package com.adityatomar.ticket_booking.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddScreenRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String theaterId;
    @NotBlank
    private int capacity;
    @NotBlank
    private int rows;

}
