package com.NamAir.NamAir_Backend.Services;

import com.NamAir.NamAir_Backend.DTO.TicketDetailsResponse;
import com.NamAir.NamAir_Backend.Model.Ticket;
import com.NamAir.NamAir_Backend.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // Method to buy a ticket
    public String buyTicket(String userId, String passengerId, LocalDate departureDate, String departureAirport,
            String arrivalAirport, String flightTime) {
        double price = calculatePrice(departureDate);
        Ticket ticket = new Ticket();
        ticket.setUserId(userId);
        ticket.setPassengerId(passengerId);
        ticket.setDepartureDate(departureDate);
        ticket.setDepartureAirport(departureAirport);
        ticket.setArrivalAirport(arrivalAirport);
        ticket.setFlightTime(flightTime);
        ticket.setTicketPrice(price);
        ticket.setStatus("Waiting for payment");
        ticket.setRefundAmount(0.0);
        ticket.setRescheduledPrice(0.0);
        ticket.setCancelledAmount(0.0);
        ticket.setRefundStatus("No Refund");
        ticket.setArrivalTime(calculateArrivalTime(flightTime));
        ticket.setPaymentAmount(0.0);
        ticketRepository.save(ticket);

        return ticket.getId();
    }

    // Method to reschedule a ticket
    public double rescheduleTicket(String ticketId, LocalDate newDepartureDate) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        // Calculate the original and new prices
        double originalPrice = ticket.getTicketPrice();
        double newPrice = calculatePrice(newDepartureDate);

        // Calculate reschedule fee (difference in price + R10)
        double rescheduleFee = calculateRescheduleFee(originalPrice, newPrice);

        ticket.setDepartureDate(newDepartureDate);
        ticket.setRescheduledPrice(newPrice);
        ticket.setStatus("Rescheduled");
        ticketRepository.save(ticket);
        return rescheduleFee;
    }

    // Method to cancel a ticket
    public double cancelTicket(String ticketId, LocalDate flightDate) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if ("Cancelled".equals(ticket.getStatus())) {
            throw new RuntimeException("Ticket is already canceled.");
        }

        long daysBeforeDeparture = ChronoUnit.DAYS.between(LocalDate.now(), flightDate);
        double refundAmount = 0;

        if (daysBeforeDeparture > 14) {
            refundAmount = ticket.getTicketPrice(); // Full refund
            ticket.setRefundStatus("100%");
        } else if (daysBeforeDeparture > 7) {
            refundAmount = ticket.getTicketPrice() * 0.5; // 50% refund
            ticket.setRefundStatus("50%");
        } else {
            refundAmount = 0; // No refund
            ticket.setRefundStatus("No Refund");
        }

        // Update the ticket's cancellation status and refund amount
        ticket.setRefundAmount(refundAmount); // Set the refund amount
        ticket.setCancelledAmount(ticket.getTicketPrice() - refundAmount); // Final canceled amount
        ticket.setStatus("Cancelled");
        ticketRepository.save(ticket);
        return refundAmount;
    }

    // Method to get all tickets for a user
    public List<Ticket> getAllTicketsForUser(String userId) {
        return ticketRepository.findByUserId(userId);
    }

    // Helper method to calculate ticket price
    public double calculatePrice(LocalDate flightDate) {
        if (flightDate != null) {
            return (flightDate.getDayOfYear() * 10 + 1000) / 12;
        } else {
            return 0.00;
        }
    }

    // Helper method to calculate the reschedule fee
    public double calculateRescheduleFee(double originalPrice, double newPrice) {
        return Math.abs(originalPrice - newPrice) + 10.00;
    }

    public TicketDetailsResponse getTicketDetails(LocalDate departureDate, String flightTime) {
        double price = calculatePrice(departureDate);
        String arrivalTime = calculateArrivalTime(flightTime);

        TicketDetailsResponse ticketDetailsResponse = new TicketDetailsResponse();
        ticketDetailsResponse.setPrice(price);
        ticketDetailsResponse.setArrivalTime(arrivalTime);

        return ticketDetailsResponse;
    }

    // Example method to calculate arrival time based on flight time
    private String calculateArrivalTime(String flightTime) {
        return "18:00";
    }

    public String paymentUpdate(String ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setStatus("Paid");
        ticket.setPaymentAmount(ticket.getTicketPrice());

        ticketRepository.save(ticket);

        return "Ticket payment successful!";
    }
}
