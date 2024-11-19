package com.NamAir.NamAir_Backend.Services;

import com.NamAir.NamAir_Backend.Model.Ticket;
import com.NamAir.NamAir_Backend.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<String> getAvailableTimes(LocalDate date) {
        // Predefined list of all possible time slots
        List<String> allTimes = Arrays.asList(
                "08:00", "10:00", "12:00",
                "14:00", "16:00", "18:00", "20:00"
        );

        // Fetch booked time slots for the given date
        List<String> bookedTimes = ticketRepository.findBookedTimesByDate(date);
        List<String> availableTimes = new ArrayList<>(allTimes);
        availableTimes.removeAll(bookedTimes);

        return availableTimes;
    }
}
