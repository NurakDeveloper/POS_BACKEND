package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.model.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.mapper.orderMapper.OrderLineMapper;
import com.pos.pos_backend.mapper.orderMapper.OrderMapper;
import com.pos.pos_backend.model.entity.order.Order;
import com.pos.pos_backend.repository.OrderLineRepository;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.service.OrderServiceMulti;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImplementService implements OrderServiceMulti {
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderRequest orderRequest(OrderRequest orderRequest) {
        // Validate and calculate exchange
        if (orderRequest.getCash() < orderRequest.getTotalAmount()) {
            throw new IllegalArgumentException("Insufficient cash for payment.");
        }

        orderRequest.setExchange(orderRequest.getCash() - orderRequest.getTotalAmount());

        // Set payment status to COMPLETED
        orderRequest.setPaymentStatus("COMPLETED");
        // Map to Order entity and save
        Order order = OrderMapper.toOrder(orderRequest);
        Order saveOrder = orderRepository.save(order);

        System.out.println("Hello");
//        ArrayList<OrderLineDto> orderLines = new ArrayList<>();
//        for (int i =0 ;i<orderRequest.getOrderLines().size();i++){
//            OrderLine orderLine = OrderLineMapper.mapToOrderLine(orderRequest.getOrderLines().get(i));
//            orderLine.setOrderId(saveOrder.getId());
//            OrderLine saveOrderLine = orderLineRepository.save(orderLine);
//            OrderLineDto ol = OrderLineMapper.mapToOrderLineDto(saveOrderLine);
//            orderLines.add(ol);
//        }

        // Map OrderLines, save them, and collect DTOs
        List<OrderLineDto> orderLines = orderRequest.getOrderLines().stream()
                .map(OrderLineMapper::mapToOrderLine)
                .peek(orderLine -> orderLine.setOrderId(saveOrder.getId())) // Set Order ID for each line
                .map(orderLineRepository::save)
                .map(OrderLineMapper::mapToOrderLineDto)
                .collect(Collectors.toList());

        // Convert back to OrderRequest with saved OrderLines
        return OrderMapper.toRequest(saveOrder, orderLines);
    }
}
