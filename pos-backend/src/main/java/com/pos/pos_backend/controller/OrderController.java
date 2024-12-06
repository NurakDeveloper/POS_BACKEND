package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.PaymentRequest;
import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.enums.PaymentStatus;
import com.pos.pos_backend.service.OrderService;
import com.pos.pos_backend.service.OrderServiceMulti;
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
    private final OrderServiceMulti orderServiceMulti;

    @PostMapping("create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto order = orderService.createOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    // CREATE Order with OrderLine
    @PostMapping("post-multiple-items")
    public ResponseEntity<?> postOrder(@RequestBody OrderRequest orderRequest) {
        // Validate if cash is sufficient
        if (orderRequest.getCash() < orderRequest.getTotalAmount()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Insufficient cash provided!");
        }

        // Calculate exchange
        orderRequest.setExchange(orderRequest.getCash() - orderRequest.getTotalAmount());

        // Process order
        try {
            OrderRequest processedOrder = orderServiceMulti.orderRequest(orderRequest);
            return new ResponseEntity<>(processedOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle unexpected errors gracefully
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the order: " + e.getMessage());
        }
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

    // Add items and update the order (adjust order items if needed)
//    @PutMapping("update-order/{orderId}")
//    public ResponseEntity<OrderDto> updateOrder(
//            @PathVariable("orderId") Long orderId,
//
//    ) {
//        OrderDto updatedOrder = orderService.updateOrder(orderId, orderRequest);
//        return ResponseEntity.ok(updatedOrder);
//    }


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
    // Generate invoice and return order details after successful payment
//    @PostMapping("generate-invoice/{orderId}")
//    public ResponseEntity<String> generateInvoice(@PathVariable("orderId") Long orderId) {
//        orderService.generateInvoice(orderId); // Logic to generate invoice number
//        return ResponseEntity.ok("Invoice generated successfully.");
//    }

}
