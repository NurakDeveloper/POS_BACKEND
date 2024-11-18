package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/order-line")
@AllArgsConstructor
public class OrderLineController {
    private OrderLineService orderLineService;

    @PostMapping("create")
    public ResponseEntity<OrderLineDto> createOrderLine(@RequestBody OrderLineDto orderLineDto){
        OrderLineDto createOrderLine = orderLineService.createOrderLine(orderLineDto);
        return new ResponseEntity<>(createOrderLine, HttpStatus.CREATED);
    }
    @GetMapping("get-by-order/{id}")
    public ResponseEntity<List<OrderLineDto>> getOrderLineByOrderId(@PathVariable("id") Long orderId){
        return ResponseEntity.ok(orderLineService.getAllOrderLineByOrderID(orderId));
    }
}
