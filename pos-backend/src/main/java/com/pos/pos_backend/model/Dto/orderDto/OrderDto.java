package com.pos.pos_backend.model.Dto.orderDto;

import com.pos.pos_backend.model.Dto.paymentDto.PaymentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long id;


    public OrderDto(){

    }
    private Long invoiceNumber;

    public OrderDto(Long id, Long invoiceNumber, Long branchId, Long orderType, Long customerId, Long acceptedBy, Integer tableNumber, Integer status, Integer numberOfPeople, Double totalAmount, Double totalDiscount, Double cash, Double exchange, Date orderDate, String description, String paymentStatus, PaymentDto payment) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.branchId = branchId;
        this.orderType = orderType;
        this.customerId = customerId;
        this.acceptedBy = acceptedBy;
        this.tableNumber = tableNumber;
        this.status = status;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.totalDiscount = totalDiscount;
        this.cash = cash;
        this.exchange = exchange;
        this.orderDate = orderDate;
        this.description = description;
        this.paymentStatus = paymentStatus;
        this.payment = payment;
    }

    private Long branchId;
    private Long orderType;
    private Long customerId;
    private Long acceptedBy;
    private Integer tableNumber;
    private Integer status;
    private Integer numberOfPeople;
    private Double totalAmount;
    private Double totalDiscount ;
    private Double cash;

    public OrderDto(Long id, Long invoiceNumber, Long branchId, Long orderType, Long customerId, Long acceptedBy, Integer tableNumber, Integer status, Integer numberOfPeople, Double totalAmount, Double totalDiscount, Double cash, Double exchange, Date orderDate, String description, String paymentStatus, PaymentDto payment, List<PaymentDto> payments) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.branchId = branchId;
        this.orderType = orderType;
        this.customerId = customerId;
        this.acceptedBy = acceptedBy;
        this.tableNumber = tableNumber;
        this.status = status;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.totalDiscount = totalDiscount;
        this.cash = cash;
        this.exchange = exchange;
        this.orderDate = orderDate;
        this.description = description;
        this.paymentStatus = paymentStatus;
        this.payment = payment;
        this.payments = payments;
    }

    private Double exchange;
    private Date orderDate;
    private String description;
    private String paymentStatus;
    private PaymentDto payment; // Include single payment details
    private List<PaymentDto> payments; // Include payment information
}
