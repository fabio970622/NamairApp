package com.NamAir.NamAir_Backend.Controller;

import com.NamAir.NamAir_Backend.DTO.*;
import com.NamAir.NamAir_Backend.Model.Ticket;
import com.NamAir.NamAir_Backend.Services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Endpoint for buying a ticket
    @PostMapping("/buyTicket")
    public BuyTicketResponse buyTicket(@RequestBody BuyTicketRequest buyTicketRequest) {
        String setBuyTicketResponse = ticketService.buyTicket(
                buyTicketRequest.getUserId(),
                buyTicketRequest.getPassengerId(),
                buyTicketRequest.getDepartureDate(),
                buyTicketRequest.getDepartureAirport(),
                buyTicketRequest.getArrivalAirport(),
                buyTicketRequest.getFlightTime());
        return new BuyTicketResponse(setBuyTicketResponse);
    }

    // Endpoint for rescheduling a ticket
    @PostMapping("/rescheduleTicket")
    public double rescheduleTicket(@RequestBody RescheduleTicketRequest rescheduleRequest) {
        return ticketService.rescheduleTicket(rescheduleRequest.getTicketId(), rescheduleRequest.getNewDepartureDate());
    }

    // Endpoint for canceling a ticket
    @PostMapping("/cancelTicket")
    public double cancelTicket(@RequestBody CancelTicketRequest cancelRequest) {
        return ticketService.cancelTicket(cancelRequest.getTicketId(), cancelRequest.getDepartureDate());
    }

    // Endpoint for calculating ticket price
    @PostMapping("/ticketPrice")
    public double getTicketPrice(@RequestBody DateRequest request) {
        LocalDate departureDate = LocalDate.parse(request.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        return ticketService.calculatePrice(departureDate);
    }

    // Endpoint to get ticket price for a specific departure date (GET request)
    @GetMapping("/ticketPrice/{date}")
    public double getTicketPriceByDate(@PathVariable String date) {
        LocalDate departureDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return ticketService.calculatePrice(departureDate);
    }

    // Endpoint for getting all tickets of a user
    @GetMapping("/tickets/{userId}")
    public List<Ticket> getAllTicketsForUser(@PathVariable String userId) {
        return ticketService.getAllTicketsForUser(userId);
    }
    // Endpoint to get ticket price and arrival time for a given flightTime
    @PostMapping("/getTicketDetails")
    public TicketDetailsResponse getTicketDetails(@RequestBody DateRequest dateRequest) {
        // Convert the received date (if necessary) into LocalDate
        LocalDate departureDate = LocalDate.parse(dateRequest.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        // Fetch ticket details (price and arrival time) from the service layer
        return ticketService.getTicketDetails(departureDate, dateRequest.getFlightTime());
    }

    // Endpoint for Paymentupdate a ticket
    @PostMapping("/paymentUpdate")
    public PaymentUpdateResponse rescheduleTicket(@RequestBody PaymentUpdateRequest paymentUpdateRequest) {
        String paymentResponse = ticketService.paymentUpdate(paymentUpdateRequest.getTicketId());
        return new PaymentUpdateResponse(paymentResponse);
    }

}
