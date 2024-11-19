package com.NamAir.NamAir_Backend.Controller;

import com.NamAir.NamAir_Backend.Model.Airport;
import com.NamAir.NamAir_Backend.Services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    // Endpoint to get all airports
    @GetMapping("/api/airports")
    public List<Airport> getAirports() {
        //airportService.Add();
        return airportService.getAllAirports();
    }
}
