package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

@Data
public class BuyTicketResponse {
    private String purchaseResponse;

    public BuyTicketResponse(String purchaseResponse) {
        this.purchaseResponse = purchaseResponse;
    }
}
