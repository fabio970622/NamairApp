package com.NamAir.NamAir_Backend.Repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.NamAir.NamAir_Backend.Model.Ticket;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    List<Ticket> findByUserId(String userId); // Find tickets by userId

    List<Ticket> findByDepartureDate(LocalDate departureDate);

    List<Ticket> findByPassengerId(String passengerId);

    @Aggregation(pipeline = {
            "{ '$match': { 'departureDate': ?0 } }",
            "{ '$project': { 'flightTime': 1 } }"
    })
    List<String> findBookedTimesByDate(LocalDate departureDate);
}
