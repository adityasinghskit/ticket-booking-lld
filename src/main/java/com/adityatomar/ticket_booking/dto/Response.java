package com.adityatomar.ticket_booking.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
public record Response(
        @NotBlank HttpStatus status,
        @NotBlank String message,
        @NotBlank Object response
        ) {
}
