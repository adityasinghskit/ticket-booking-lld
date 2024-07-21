package com.adityatomar.ticket_booking.service;

import com.adityatomar.ticket_booking.Repository.TheaterRepository;
import com.adityatomar.ticket_booking.dto.AddRequestDto;
import com.adityatomar.ticket_booking.exception.TheaterAlreadyExistsException;
import com.adityatomar.ticket_booking.model.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public Theater saveTheater(AddRequestDto requestDto) {
        Optional<Theater> theaterOpt = theaterRepository.findByName(requestDto.getName());
        if (theaterOpt.isPresent()) {
            throw new TheaterAlreadyExistsException("Theater exists by that name");
        }
        return theaterRepository.save(new Theater(requestDto.getName()));
    }


}
