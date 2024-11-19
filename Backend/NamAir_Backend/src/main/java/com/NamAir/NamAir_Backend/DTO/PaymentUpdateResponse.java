package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PaymentUpdateResponse {
    private String paymentResponse;

    // Constructor to initialize the paymentResponse field
    public PaymentUpdateResponse(String paymentResponse) {
        this.paymentResponse = paymentResponse;
    }
}
