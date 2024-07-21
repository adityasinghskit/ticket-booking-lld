package com.adityatomar.ticket_booking.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddRequestDto {
    @NotBlank
    private String name;
}
