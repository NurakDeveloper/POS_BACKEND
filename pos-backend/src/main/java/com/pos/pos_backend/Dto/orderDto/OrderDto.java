package com.pos.pos_backend.Dto.orderDto;

import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Long invoiceNumber;
    private Long orderType;
    private Long customerId;
    private Long acceptedBy;
    private Integer tableNumber;
    private Integer status;
    private Integer numberOfPeople;
    private Double totalAmount;
    private Double cash;
    private Double exchange;
    private Date orderDate;
    private String description;
    private String paymentStatus;
    private PaymentDto payment; // Include single payment details
    private List<PaymentDto> payments; // Include payment information
}
