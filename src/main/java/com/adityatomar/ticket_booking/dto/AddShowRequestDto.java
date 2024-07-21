package com.adityatomar.ticket_booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddShowRequestDto {
    @NotBlank
    private String screenId;
    @NotBlank
    private String movieId;
    @NotNull
    @JsonSerialize(as = LocalDateTime.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Future(message = "Invalid: Show time")
    private LocalDateTime startTime;
    @NotNull
    private int timeInMinutes;

}
