package com.adityatomar.ticket_booking.service;

import com.adityatomar.ticket_booking.Repository.MovieRepository;
import com.adityatomar.ticket_booking.exception.EntityNotFoundException;
import com.adityatomar.ticket_booking.exception.MovieAlreadyExistsException;
import com.adityatomar.ticket_booking.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    private Map<String, Movie> movies = new HashMap<>();

    public Movie save(String name){
        Optional<Movie> movieOpt = movieRepository.findByName(name);
        if(movieOpt.isPresent()){
            throw new MovieAlreadyExistsException("Movie exists by that name.");
        }
        return movieRepository.save(Movie.builder().name(name).build());
    }

    public Movie findById(String id){
        return movieRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Movie not found."));
    }

}
