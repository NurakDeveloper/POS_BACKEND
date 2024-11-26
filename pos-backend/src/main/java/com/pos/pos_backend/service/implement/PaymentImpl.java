package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
import com.pos.pos_backend.mapper.paymentMapper.PaymentMapper;
import com.pos.pos_backend.model.accounting.Payment;
import com.pos.pos_backend.model.order.Order;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.repository.accounting.PaymentRepository;
import com.pos.pos_backend.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public PaymentDto addPayment(Long orderId, PaymentDto paymentDto) {
        // Check if the order exists
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        // Map DTO to entity
        Payment payment = PaymentMapper.mapToPayment(paymentDto);
        payment.setOrder(order);
        payment.setPaymentStatus("Paid"); // Default to "Paid" for now
        payment.setPaymentDate(new java.util.Date()); // Set current date

        // Save payment and return the DTO
        Payment savedPayment = paymentRepository.save(payment);
        return PaymentMapper.mapToPaymentDto(savedPayment);
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.mapToPayment(paymentDto);
        Order order = orderRepository.findById(paymentDto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + paymentDto.getOrderId()));
        payment.setOrder(order);
        payment.setPaymentMethod(paymentDto.getPaymentMethod()); // Handle paymentMethod as a string
        Payment savePayment = paymentRepository.save(payment);
        return PaymentMapper.mapToPaymentDto(savePayment);
    }

    @Override
    public List<PaymentDto> getPaymentsByOrderId(Long orderId) {
        List<Payment> payments = paymentRepository.findByOrderId(orderId);
        return payments.stream()
                .map(PaymentMapper::mapToPaymentDto)
                .collect(Collectors.toList());
    }

    @Override
    public Double getTotalPaymentsForOrder(Long orderId) {
        return paymentRepository.findByOrderId(orderId).stream()
                .mapToDouble(Payment::getAmountPaid)
                .sum();
    }
}
