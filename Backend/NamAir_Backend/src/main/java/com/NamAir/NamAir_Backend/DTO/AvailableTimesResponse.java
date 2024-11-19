package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AvailableTimesResponse {
    private List<String> availableTimes;

    // Constructor to initialize the availableTimes field
    public AvailableTimesResponse(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
