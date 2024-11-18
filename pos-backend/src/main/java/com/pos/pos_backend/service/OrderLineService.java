package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.orderDto.OrderLineDto;

import java.util.List;

public interface OrderLineService {
    OrderLineDto createOrderLine(OrderLineDto orderLineDto);
    List<OrderLineDto> getAllOrderLineByOrderID(Long orderID);
}
