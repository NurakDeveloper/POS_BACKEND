package com.pos.pos_backend.mapper.orderMapper;

import com.pos.pos_backend.model.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.model.entity.order.OrderLine;


public class OrderLineMapper {
    public static OrderLineDto mapToOrderLineDto(OrderLine orderLine){
        return new OrderLineDto(
                orderLine.getId(),
                orderLine.getOrderId(),
                orderLine.getProductId(),
                orderLine.getPrice(),
                orderLine.getQty(),
                orderLine.getAmount()
        );
    }
    public static OrderLine mapToOrderLine(OrderLineDto orderLineDto){
        return new OrderLine(
                orderLineDto.getId(),
                orderLineDto.getOrderId(),
                orderLineDto.getProductId(),
                orderLineDto.getPrice(),
                orderLineDto.getQty(),
                orderLineDto.getAmount()

        );
    }
}
