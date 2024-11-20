package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.model.order.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    List<OrderDto> getAllOrder();
    OrderDto getOrderByID(Long orderId);
    Double totalOrderToday(Date date);

}
