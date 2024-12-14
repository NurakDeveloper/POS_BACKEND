package com.pos.pos_backend.model.entity.accounting;

import com.pos.pos_backend.model.entity.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Double amountPaid;
    @NotNull
    private String paymentMethod; // Store as String in the database

    private String paymentStatus;
    private Date paymentDate;

//    public PaymentMethod getPaymentMethod() {
//        return new PaymentMethod(paymentMethod);
//    }

    public void setOrder(Order order) {
    }

    public void setPaymentMethod(String paymentMethod) {
    }
}
