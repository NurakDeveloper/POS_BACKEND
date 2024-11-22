package com.pos.pos_backend.model.accounting;

import com.pos.pos_backend.model.PaymentMethod;
import com.pos.pos_backend.model.order.Order;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Double amountPaid; // Payment amount
    @Enumerated(EnumType.STRING) // Or EnumType.ORDINAL if you prefer storing the enum's ordinal value.
    private PaymentMethod paymentMethod;
//    private String paymentMethod; // e.g., "Cash", "Credit Card", "Mobile Payment"
    private String paymentStatus; // e.g., "Paid", "Pending", "Failed"
    private Date paymentDate; // Date of payment

    public void setPaymentMethod(String paymentMethod) {

    }
}
