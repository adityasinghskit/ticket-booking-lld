package com.adityatomar.ticket_booking.service;

import com.adityatomar.ticket_booking.Repository.ScreenRepository;
import com.adityatomar.ticket_booking.Repository.TheaterRepository;
import com.adityatomar.ticket_booking.dto.AddScreenRequestDto;
import com.adityatomar.ticket_booking.exception.EntityNotFoundException;
import com.adityatomar.ticket_booking.model.Screen;
import com.adityatomar.ticket_booking.model.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;

    public Screen saveScreen(AddScreenRequestDto requestDto) {
        Optional<Theater> theaterOpt = theaterRepository.findById(requestDto.getTheaterId());
        if (!theaterOpt.isPresent()) {
            throw new EntityNotFoundException("Theater not found.");
        }
        return screenRepository.save(new Screen(requestDto.getName(), requestDto.getCapacity(),
                requestDto.getRows(), theaterOpt.get()));
    }

    public Screen findById(String id){
        return screenRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Screen not found."));
    }
}
