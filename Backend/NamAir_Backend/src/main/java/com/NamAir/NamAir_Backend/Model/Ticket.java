package com.NamAir.NamAir_Backend.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "tickets")
@Data
public class Ticket {

    @Id
    private String id;
    private String userId;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDate departureDate;
    private String flightTime;
    private double ticketPrice;
    private double rescheduledPrice;
    private double cancelledAmount;
    private double refundAmount;

    private String passengerId;

    private String status;
    private String refundStatus;
    private String arrivalTime;
    private double paymentAmount;
}
