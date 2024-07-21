package com.adityatomar.ticket_booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ApiError {
    private HttpStatus status;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private String debugMessage;
}
