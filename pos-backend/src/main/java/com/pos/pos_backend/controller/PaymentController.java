package com.pos.pos_backend.controller;

import com.pos.pos_backend.model.Dto.paymentDto.PaymentDto;
import com.pos.pos_backend.model.entity.order.Order;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/payment")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final OrderRepository orderRepository; // Inject OrderRepository

    @PostMapping("add/{orderId}")
    public ResponseEntity<PaymentDto> addPayment(
            @PathVariable("orderId") Long orderId,
            @Valid @RequestBody PaymentDto paymentDto
    ) {
        return new ResponseEntity<>(paymentService.addPayment(orderId, paymentDto), HttpStatus.CREATED);
    }
    @PostMapping("create")
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto){
        PaymentDto payment = paymentService.createPayment(paymentDto);
        return new ResponseEntity<>(payment,HttpStatus.CREATED);
    }

    @GetMapping("list/{orderId}")
    public ResponseEntity<List<PaymentDto>> getPaymentsByOrderId(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentsByOrderId(orderId));
    }

    @GetMapping("total/{orderId}")
    public ResponseEntity<Double> getTotalPaymentsForOrder(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(paymentService.getTotalPaymentsForOrder(orderId));
    }

    @GetMapping("status/{orderId}")
    public ResponseEntity<String> getOrderPaymentStatus(@PathVariable("orderId") Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return ResponseEntity.ok(order.getPaymentStatus().toString());
    }

}
