package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
import com.pos.pos_backend.enums.PaymentStatus;
import com.pos.pos_backend.exception.ResourceNotFoundException;
import com.pos.pos_backend.mapper.orderMapper.OrderMapper;
import com.pos.pos_backend.mapper.paymentMapper.PaymentMapper;
import com.pos.pos_backend.model.accounting.Payment;
import com.pos.pos_backend.model.order.Order;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.repository.accounting.PaymentRepository;
import com.pos.pos_backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order orderObj = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(orderObj);
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public List<OrderDto> getAllOrder() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderByID(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public Double totalOrderToday(Date date) {
        return orderRepository.findTotalOrderToday(formatOrderDate(date));
    }

    @Override
    public PaymentDto addPayment(Long orderId, PaymentDto paymentDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + orderId));

        // Map DTO to Payment
        Payment payment = PaymentMapper.mapToPayment(paymentDto);
        payment.setOrder(order);
        payment.setPaymentDate(new Date());
        paymentRepository.save(payment);

        // Calculate total payments for the order
        Double totalPaid = paymentRepository.findByOrderId(orderId).stream()
                .mapToDouble(Payment::getAmountPaid)
                .sum();

        // Update order payment status
        if (totalPaid >= order.getTotalAmount()) {
            order.setPaymentStatus(PaymentStatus.COMPLETED);
        } else {
            order.setPaymentStatus(PaymentStatus.PENDING);
        }
        orderRepository.save(order);

        return PaymentMapper.mapToPaymentDto(payment);
    }

    @Override
    public OrderDto addPaymentToOrder(Long orderId, Double amountPaid, String paymentMethod) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + orderId));

        if (amountPaid <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmountPaid(amountPaid);
        payment.setPaymentMethod(paymentMethod);
        paymentRepository.save(payment);

        // Recalculate payments
        Double totalPaid = paymentRepository.findByOrderId(orderId).stream()
                .mapToDouble(Payment::getAmountPaid)
                .sum();

        // Update order's payment status
        if (totalPaid >= order.getTotalAmount()) {
            order.setPaymentStatus(PaymentStatus.COMPLETED);
        } else {
            order.setPaymentStatus(PaymentStatus.PENDING);
        }

        orderRepository.save(order);

        return OrderMapper.mapToOrderDto(order);
    }

//    @Override
//    public OrderDto createOrderWithPayment(OrderDto orderDto, PaymentDto paymentDto) {
//        // Create the order
//        Order order = orderRepository.save(OrderMapper.mapToOrder(orderDto));
//
//        // Handle the payment
//        Payment payment = PaymentMapper.mapToPayment(paymentDto);
//        payment.setOrder(order);
//        paymentRepository.save(payment);
//
//        // Update the payment status in the order
//        order.setPaymentStatus(payment.getPaymentStatus());
//        return OrderMapper.mapToOrderDto(order);
//    }

    private String formatOrderDate(Date orderDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(orderDate);
    }

    @Override
    public void updateOrderPaymentStatus(Long orderId, PaymentStatus paymentStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + orderId));
        order.setPaymentStatus(paymentStatus); // Assuming PaymentStatus is an ENUM
        orderRepository.save(order);
    }

}
