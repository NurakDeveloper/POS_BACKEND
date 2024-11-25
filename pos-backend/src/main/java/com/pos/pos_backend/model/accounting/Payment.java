package com.pos.pos_backend.model.accounting;

import com.pos.pos_backend.model.PaymentMethod;
import com.pos.pos_backend.model.order.Order;
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
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String paymentStatus;
    private Date paymentDate;
    public void setPaymentMethod(@NotNull PaymentMethod paymentMethod) {

    }

    public void setOrder(Order order) {
    }

    public void setPaymentMethod(String paymentMethod) {
    }
}
