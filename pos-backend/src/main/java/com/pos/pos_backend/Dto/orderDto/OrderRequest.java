package com.pos.pos_backend.Dto.orderDto;

import com.pos.pos_backend.model.accounting.Payment;
import com.pos.pos_backend.model.order.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data

public class OrderRequest {
    private Long id;
    private Long invoiceNumber;
    private Long orderType;
    private Long customerId;
    private Long acceptedBy;
    private Integer tableNumber;

    public OrderRequest(Long id, Long invoiceNumber, Long orderType, Long customerId, Long acceptedBy, Integer tableNumber, Integer status, Integer numberOfPeople, Double totalAmount, Double cash, Double exchange, Date orderDate, String description, String paymentStatus, List<OrderLineDto> orderLines) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.orderType = orderType;
        this.customerId = customerId;
        this.acceptedBy = acceptedBy;
        this.tableNumber = tableNumber;
        this.status = status;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.cash = cash;
        this.exchange = exchange;
        this.orderDate = orderDate;
        this.description = description;
        this.paymentStatus = paymentStatus;
        this.orderLines = orderLines;
    }
    public OrderRequest(){

    }

    public OrderRequest(Long id, Long invoiceNumber, Long orderType, Long customerId, Long acceptedBy, Integer tableNumber, Integer status, Integer numberOfPeople, Double totalAmount, Double cash, Double exchange, Date orderDate, String description, String paymentStatus) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.orderType = orderType;
        this.customerId = customerId;
        this.acceptedBy = acceptedBy;
        this.tableNumber = tableNumber;
        this.status = status;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.cash = cash;
        this.exchange = exchange;
        this.orderDate = orderDate;
        this.description = description;
        this.paymentStatus = paymentStatus;
    }

    private Integer status;
    private Integer numberOfPeople;
    private Double totalAmount;
    private Double cash;
    private Double exchange;
    private Date orderDate;
    private String description;
    private String paymentStatus;
    private List<OrderLineDto> orderLines;
}
