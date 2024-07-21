package com.adityatomar.ticket_booking.controller;

import com.adityatomar.ticket_booking.dto.AddRequestDto;
import com.adityatomar.ticket_booking.dto.Response;
import com.adityatomar.ticket_booking.model.Movie;
import com.adityatomar.ticket_booking.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> addMovie(@RequestBody @Valid AddRequestDto requestBody) {

        Movie savedMovie = movieService.save(requestBody.getName());
        return ResponseEntity.ok(new Response(HttpStatus.OK, "Success",
                Map.of("id", savedMovie.getId())));

    }

}
