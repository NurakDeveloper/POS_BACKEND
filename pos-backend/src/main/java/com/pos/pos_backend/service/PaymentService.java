package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.paymentDto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto addPayment(Long orderId, PaymentDto paymentDto);
    PaymentDto createPayment(PaymentDto paymentDto);
    List<PaymentDto> getPaymentsByOrderId(Long orderId);
    Double getTotalPaymentsForOrder(Long orderId);
}
