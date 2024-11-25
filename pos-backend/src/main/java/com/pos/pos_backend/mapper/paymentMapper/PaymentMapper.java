package com.pos.pos_backend.mapper.paymentMapper;

import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
import com.pos.pos_backend.model.accounting.Payment;

public class PaymentMapper {

    public static PaymentDto mapToPaymentDto(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getOrderId(), // Directly use orderId without accessing getOrder()
                payment.getAmountPaid(),
                payment.getPaymentMethod(),
                payment.getPaymentStatus(),
                payment.getPaymentDate()
        );
    }

    public static Payment mapToPayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setOrderId(paymentDto.getOrderId()); // Directly set orderId
        payment.setAmountPaid(paymentDto.getAmountPaid());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        return payment;
    }
}
