package com.pos.pos_backend.repository.accounting;

import com.pos.pos_backend.model.entity.accounting.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderId(Long orderId); // Retrieve payments for a specific order
}
