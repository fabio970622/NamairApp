package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BuyTicketRequest {
    private String userId;
    private String passengerId;
    private LocalDate departureDate;
    private String departureAirport;
    private String arrivalAirport;
    private String flightTime;
}
