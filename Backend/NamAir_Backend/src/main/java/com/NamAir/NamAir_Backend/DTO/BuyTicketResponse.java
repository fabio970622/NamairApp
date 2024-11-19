package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

@Data
public class BuyTicketResponse {
    private String purchaseResponse;

    // Constructor to initialize the availableTimes field
    public BuyTicketResponse(String purchaseResponse) {
        this.purchaseResponse = purchaseResponse;
    }
}
