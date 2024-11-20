package com.NamAir.NamAir_Backend.Controller;

import com.NamAir.NamAir_Backend.DTO.AvailableTimesRequest;
import com.NamAir.NamAir_Backend.DTO.AvailableTimesResponse;
import com.NamAir.NamAir_Backend.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/availableTimes")
    public AvailableTimesResponse getAvailableTimes(@RequestBody AvailableTimesRequest request) {
        LocalDate departureDate = LocalDate.parse(request.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        List<String> availableTimes = bookingService.getAvailableTimes(departureDate);
        return new AvailableTimesResponse(availableTimes);
    }
}
