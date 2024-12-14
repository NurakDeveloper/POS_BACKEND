package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.mapper.orderMapper.OrderLineMapper;
import com.pos.pos_backend.model.entity.order.OrderLine;
import com.pos.pos_backend.repository.OrderLineRepository;
import com.pos.pos_backend.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderLineImpl implements OrderLineService {
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLineDto createOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = OrderLineMapper.mapToOrderLine(orderLineDto);
        OrderLine saveOrderLineToDataStore = orderLineRepository.save(orderLine);
        return OrderLineMapper.mapToOrderLineDto(saveOrderLineToDataStore);
    }

    @Override
    public List<OrderLineDto> getAllOrderLineByOrderID(Long orderID) {
        List<OrderLine> orderLine = orderLineRepository.findAllByOrderID(orderID);
        return orderLine.stream().map(OrderLineMapper :: mapToOrderLineDto).collect(Collectors.toList());
    }
}
