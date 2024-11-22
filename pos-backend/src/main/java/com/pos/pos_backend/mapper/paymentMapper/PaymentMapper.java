package com.pos.pos_backend.mapper.paymentMapper;

import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
import com.pos.pos_backend.model.accounting.Payment;

public class PaymentMapper {

    public static PaymentDto mapToPaymentDto(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getOrder().getId(),
                payment.getAmountPaid(),
                payment.getPaymentMethod(),
                payment.getPaymentStatus(),
                payment.getPaymentDate()
        );
    }

    public static Payment mapToPayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setAmountPaid(paymentDto.getAmountPaid());
        payment.setPaymentMethod(paymentDto.getPaymentMethod().toString());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        return payment;
    }
}
