package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.mapper.orderMapper.OrderMapper;
import com.pos.pos_backend.model.order.Order;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImpl implements OrderService {
    private OrderRepository orderRepository;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order orderObj = OrderMapper.mapToOrder(orderDto);
        Order saveOrderToDataStore = orderRepository.save(orderObj);
        return OrderMapper.mapToOrderDto(saveOrderToDataStore);
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<Order> getOrderFromDataStore = orderRepository.findAll();
        return getOrderFromDataStore.stream().map(OrderMapper::mapToOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderByID(Long orderId) {
        Order getOrder = orderRepository.findById(orderId).orElseThrow();
        return OrderMapper.mapToOrderDto(getOrder);
    }

    @Override
    public Double totalOrderToday(Date date) {
        return orderRepository.findTotalOrderToday(formatOrderDate(date));
    }
    public String formatOrderDate(Date orderDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(orderDate);
    }
}
