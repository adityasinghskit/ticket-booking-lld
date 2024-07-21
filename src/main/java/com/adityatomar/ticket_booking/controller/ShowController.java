package com.adityatomar.ticket_booking.controller;

import com.adityatomar.ticket_booking.dto.AddShowRequestDto;
import com.adityatomar.ticket_booking.dto.Response;
import com.adityatomar.ticket_booking.model.Show;
import com.adityatomar.ticket_booking.service.ShowService;
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
@RequestMapping("/show")
public class ShowController {
    private final ShowService showService;

    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Response> addShow(@RequestBody @Valid AddShowRequestDto requestBody) {
        Show show = showService.createShow(requestBody);
        return ResponseEntity.ok(new Response(HttpStatus.OK, "Success",
                Map.of("id", show.getId())));

    }
}
