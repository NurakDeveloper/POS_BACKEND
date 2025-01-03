package com.pos.pos_backend.model.entity.order;

import com.pos.pos_backend.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long invoiceNumber;
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
    private Double exchange;
    private Date orderDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
}
