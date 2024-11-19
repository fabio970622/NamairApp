package com.NamAir.NamAir_Backend.Repository;

import com.NamAir.NamAir_Backend.Model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AirportRepository extends MongoRepository<Airport, String> {
    // You can use findByCode or findByName methods if you need to query airports by code or name
}
