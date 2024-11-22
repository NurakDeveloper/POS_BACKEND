package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.PaymentRequest;
import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.enums.PaymentStatus;
import com.pos.pos_backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto order = orderService.createOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @GetMapping("total-order")
    public Double getTotalToday(){
        return orderService.totalOrderToday(new Date());
    }
    @GetMapping("list-order")
    public ResponseEntity<List<OrderDto>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long orderId){
        return ResponseEntity.ok(orderService.getOrderByID(orderId));
    }
    @PutMapping("add-payment/{orderId}")
    public ResponseEntity<OrderDto> addPaymentToOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody PaymentRequest paymentRequest
    ) {
        Double amountPaid = paymentRequest.getAmountPaid();
        String paymentMethod = paymentRequest.getPaymentMethod();
        OrderDto updatedOrder = orderService.addPaymentToOrder(orderId, amountPaid, paymentMethod);
        return ResponseEntity.ok(updatedOrder);
    }
    @GetMapping("status/{orderId}")
    public ResponseEntity<String> getOrderPaymentStatus(@PathVariable("orderId") Long orderId) {
        OrderDto order = orderService.getOrderByID(orderId); // Call the service layer
        return ResponseEntity.ok(order.getPaymentStatus().toString());
    }
    @PatchMapping("update-payment-status/{orderId}")
    public ResponseEntity<String> updateOrderPaymentStatus(
            @PathVariable Long orderId,
            @RequestParam PaymentStatus paymentStatus) {
        orderService.updateOrderPaymentStatus(orderId, paymentStatus);
        return ResponseEntity.ok("Payment status updated successfully.");
    }

}
