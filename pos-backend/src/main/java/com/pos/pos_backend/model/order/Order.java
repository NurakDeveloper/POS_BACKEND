package com.pos.pos_backend.model.order;

import com.pos.pos_backend.enums.OrderStatus;
import com.pos.pos_backend.enums.PaymentStatus;
import com.pos.pos_backend.model.accounting.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Order(Long id, Long invoiceNumber, Long orderType, Long customerId, Long acceptedBy, Integer tableNumber, Integer status, Integer numberOfPeople, Double totalAmount, Double cash, Double exchange, Date orderDate, String description, List<Payment> payments, PaymentStatus paymentStatus) {
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
        this.payments = payments;
        this.paymentStatus = paymentStatus;
    }

    public Order(){

    }
    public Order(Long id, Long invoiceNumber, Long orderType, Long customerId, Long acceptedBy, Integer tableNumber, Integer status, Integer numberOfPeople, Double totalAmount, Double cash, Double exchange, Date orderDate, String description, PaymentStatus paymentStatus) {
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments; // Linking Payment with Order

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING; // Default to PENDING
}
