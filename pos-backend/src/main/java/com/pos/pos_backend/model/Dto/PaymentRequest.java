package com.pos.pos_backend.model.Dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Double amountPaid;
    private String paymentMethod;
}