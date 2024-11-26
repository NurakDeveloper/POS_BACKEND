package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.PaymentMethodDto;
import com.pos.pos_backend.model.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodMapper {
    public PaymentMethodDto toDto(PaymentMethod paymentMethod) {
        return new PaymentMethodDto(paymentMethod.getId(), paymentMethod.getName());
    }

    public PaymentMethod toEntity(PaymentMethodDto paymentMethodDto) {
        return new PaymentMethod(paymentMethodDto.getId(), paymentMethodDto.getName());
    }
}
