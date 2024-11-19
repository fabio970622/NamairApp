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
    private double ticketPrice; // The price of the ticket
    private double rescheduledPrice; // Price for rescheduled ticket
    private double cancelledAmount; // Amount after canceling (ticket price minus refund)
    private double refundAmount; // Calculated refund based on policy

    private String passengerId; // Foreign reference to Passenger

    private String status; // Booked, Rescheduled, Canceled
    private String refundStatus; // 100%, 50%, No Refund
    private String arrivalTime;
    private double paymentAmount;
}
