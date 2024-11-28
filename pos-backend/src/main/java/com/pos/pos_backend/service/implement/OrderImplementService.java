package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.mapper.orderMapper.OrderLineMapper;
import com.pos.pos_backend.mapper.orderMapper.OrderMapper;
import com.pos.pos_backend.model.order.Order;
import com.pos.pos_backend.model.order.OrderLine;
import com.pos.pos_backend.repository.OrderLineRepository;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.service.OrderServiceMulti;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImplementService implements OrderServiceMulti {
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;
    @Override
    public OrderRequest orderRequest(OrderRequest orderRequest) {
        System.out.println("helloddd");
        Order order = OrderMapper.toOrder(orderRequest);
        Order saveOrder = orderRepository.save(order);
        System.out.println("Hello");
        ArrayList<OrderLineDto> orderLines = new ArrayList<>();
        for (int i =0 ;i<orderRequest.getOrderLines().size();i++){
            OrderLine orderLine = OrderLineMapper.mapToOrderLine(orderRequest.getOrderLines().get(i));
            orderLine.setOrderId(saveOrder.getId());
            OrderLine saveOrderLine = orderLineRepository.save(orderLine);
            OrderLineDto ol = OrderLineMapper.mapToOrderLineDto(saveOrderLine);
            orderLines.add(ol);
        }

        return OrderMapper.toRequest(
                saveOrder,
                orderLines.stream().toList()   // Collect to a List
        );
    }
}
