package com.pos.pos_backend.Dto.paymentDto;

import com.pos.pos_backend.model.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;

    private Long orderId;

    @NotNull(message = "Payment amount is required")
    @Positive(message = "Payment amount must be positive")
    private Double amountPaid;

    @NotNull(message = "Payment method is required")
    private String paymentMethod; // Use String instead of PaymentMethod class

    private String paymentStatus;

    private Date paymentDate;



}
