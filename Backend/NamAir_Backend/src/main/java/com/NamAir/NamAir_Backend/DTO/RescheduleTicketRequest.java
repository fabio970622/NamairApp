package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RescheduleTicketRequest {
    private String ticketId;
    private LocalDate newDepartureDate;
}