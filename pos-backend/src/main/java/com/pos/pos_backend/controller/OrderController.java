package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.orderDto.OrderDto;
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
    private OrderService orderService ;

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
}
