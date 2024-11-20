package com.NamAir.NamAir_Backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PaymentUpdateResponse {
    private String paymentResponse;

    public PaymentUpdateResponse(String paymentResponse) {
        this.paymentResponse = paymentResponse;
    }
}
