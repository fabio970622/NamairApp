package com.NamAir.NamAir_Backend.Services;

import com.NamAir.NamAir_Backend.Model.Airport;
import com.NamAir.NamAir_Backend.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
//    public Airport Add() {
//        Airport airport = new Airport();
//        airport.setCode("DUR");
//        airport.setName("King Shaka International Airport (Durban)");
//        return airportRepository.save(airport);
//    }
}
