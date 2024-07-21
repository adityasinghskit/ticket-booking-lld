package com.adityatomar.ticket_booking.service;

import com.adityatomar.ticket_booking.Repository.ShowRepository;
import com.adityatomar.ticket_booking.dto.AddShowRequestDto;
import com.adityatomar.ticket_booking.exception.EntityNotFoundException;
import com.adityatomar.ticket_booking.exception.ScreenNotAvailableException;
import com.adityatomar.ticket_booking.model.Movie;
import com.adityatomar.ticket_booking.model.Screen;
import com.adityatomar.ticket_booking.model.Show;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    public Show createShow(AddShowRequestDto request){
        Movie movie = movieService.findById(request.getMovieId());
        Screen screen = screenService.findById(request.getScreenId());
        if(!isScreenAvailable(screen)){
            throw new ScreenNotAvailableException("Screen is running a show");
        }
        return showRepository.save(
                Show.builder()
                .movie(movie)
                .screen(screen)
                .startTime(LocalDateTime.now())
                .timeInMinutes(140).build()
        );
    }

    private boolean isScreenAvailable(Screen screen){
        //todo: If the screen is currently running a show return false otherwise true
        return true;
    }
}
