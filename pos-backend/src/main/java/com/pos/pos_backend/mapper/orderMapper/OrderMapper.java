package com.pos.pos_backend.mapper.orderMapper;

import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.model.order.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getInvoiceNumber(),
                order.getOrderType(),
                order.getCustomerId(),
                order.getAcceptedBy(),
                order.getTableNumber(),
                order.getStatus(),
                order.getNumberOfPeople(),
                order.getTotalAmount(),
                order.getCash(),
                order.getExchange(),
                order.getOrderDate(),
                order.getDescription()
        );
    }
    public static Order mapToOrder(OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getInvoiceNumber(),
                orderDto.getOrderType(),
                orderDto.getCustomerId(),
                orderDto.getAcceptedBy(),
                orderDto.getTableNumber(),
                orderDto.getStatus(),
                orderDto.getNumberOfPeople(),
                orderDto.getTotalAmount(),
                orderDto.getCash(),
                orderDto.getExchange(),
                orderDto.getOrderDate(),
                orderDto.getDescription()
        );
    }
}
