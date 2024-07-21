package com.adityatomar.ticket_booking.controller;

import com.adityatomar.ticket_booking.dto.AddRequestDto;
import com.adityatomar.ticket_booking.dto.AddScreenRequestDto;
import com.adityatomar.ticket_booking.dto.Response;
import com.adityatomar.ticket_booking.model.Screen;
import com.adityatomar.ticket_booking.model.Theater;
import com.adityatomar.ticket_booking.service.ScreenService;
import com.adityatomar.ticket_booking.service.TheaterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class TheaterController {
    private final TheaterService theaterService;
    private final ScreenService screenService;

    @PostMapping(value = "/theater/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> addTheater(@RequestBody @Valid AddRequestDto requestBody) {
        Theater savedTheater = theaterService.saveTheater(requestBody);
        return ResponseEntity.ok(new Response(HttpStatus.OK, "Success",
                Map.of("id", savedTheater.getId())));

    }

    @PostMapping(value = "/screen/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> addScreen(@RequestBody @Valid AddScreenRequestDto requestBody) {
        Screen savedScreen = screenService.saveScreen(requestBody);
        return ResponseEntity.ok(new Response(HttpStatus.OK, "Success",
                Map.of("id", savedScreen.getId())));


    }

}
