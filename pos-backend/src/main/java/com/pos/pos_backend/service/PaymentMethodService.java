package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.PaymentMethodDto;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethodDto createPaymentMethod(PaymentMethodDto paymentMethodDto);
    PaymentMethodDto updatePaymentMethod(Long id, PaymentMethodDto paymentMethodDto);
    void deletePaymentMethod(Long id);
    PaymentMethodDto getPaymentMethodById(Long id);
    List<PaymentMethodDto> getAllPaymentMethods();
}
