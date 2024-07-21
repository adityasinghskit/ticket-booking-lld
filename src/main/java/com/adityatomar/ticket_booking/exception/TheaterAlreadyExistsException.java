package com.adityatomar.ticket_booking.exception;

public class TheaterAlreadyExistsException extends RuntimeException{
    public TheaterAlreadyExistsException(String message){
        super(message);
    }
}
