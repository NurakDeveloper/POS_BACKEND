package com.pos.pos_backend.Dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Double amountPaid;
    private String paymentMethod;
}