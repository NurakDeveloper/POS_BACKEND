package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.mapper.orderMapper.InvoiceMapper;
import com.pos.pos_backend.model.Dto.orderDto.InvoiceDto;
import com.pos.pos_backend.model.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.model.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.mapper.orderMapper.OrderLineMapper;
import com.pos.pos_backend.mapper.orderMapper.OrderMapper;
import com.pos.pos_backend.model.entity.order.Order;
import com.pos.pos_backend.model.entity.order.OrderLine;
import com.pos.pos_backend.repository.OrderLineRepository;
import com.pos.pos_backend.repository.OrderRepository;
import com.pos.pos_backend.service.OrderServiceMulti;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImplementService implements OrderServiceMulti {
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;
    private InvoiceMapper invoiceMapper ;

    @Override
    public OrderRequest orderRequest(OrderRequest orderRequest) {
        // Validate and calculate exchange
        if (orderRequest.getCash() < orderRequest.getTotalAmount()) {
            throw new IllegalArgumentException("Insufficient cash for payment.");
        }

        orderRequest.setExchange(orderRequest.getCash() - orderRequest.getTotalAmount());

        orderRequest.setInvoiceNumber(generateUniqueInvoiceNumber());
        // Set payment status to COMPLETED
        orderRequest.setPaymentStatus("COMPLETED");
        // Map to Order entity and save
        Order order = OrderMapper.toOrder(orderRequest);
        Order saveOrder = orderRepository.save(order);

        System.out.println("Hello");


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

    @Override
    public InvoiceDto sale(OrderRequest orderRequest) {
        if (orderRequest.getCash() < orderRequest.getTotalAmount()) {
            throw new IllegalArgumentException("Insufficient cash for payment.");
        }

        orderRequest.setExchange(orderRequest.getCash() - orderRequest.getTotalAmount());

        orderRequest.setInvoiceNumber(generateUniqueInvoiceNumber());
        // Set payment status to COMPLETED
        orderRequest.setPaymentStatus("COMPLETED");
        // Map to Order entity and save
        Order order = OrderMapper.toOrder(orderRequest);
        Order saveOrder = orderRepository.save(order);

        System.out.println("Hello");


        // Map OrderLines, save them, and collect DTOs
        List<OrderLineDto> orderLines = orderRequest.getOrderLines().stream()
                .map(OrderLineMapper::mapToOrderLine)
                .peek(orderLine -> orderLine.setOrderId(saveOrder.getId())) // Set Order ID for each line
                .map(orderLineRepository::save)
                .map(OrderLineMapper::mapToOrderLineDto)
                .collect(Collectors.toList());



        return invoiceMapper.mapToInvoiceDto(orderRequest);
    }

    @Override
    public OrderRequest updateOrder(Long id, OrderRequest orderRequest) {

        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        // Validate cash and calculate exchange
        if (orderRequest.getCash() < orderRequest.getTotalAmount()) {
            throw new IllegalArgumentException("Insufficient cash for payment.");
        }
        existingOrder.setExchange(orderRequest.getCash() - orderRequest.getTotalAmount());

        // Update order fields
        existingOrder.setBranchId(orderRequest.getBranchId());
        existingOrder.setOrderType(orderRequest.getOrderType());
        existingOrder.setCustomerId(orderRequest.getCustomerId());
        existingOrder.setAcceptedBy(orderRequest.getAcceptedBy());
        existingOrder.setTableNumber(orderRequest.getTableNumber());
        existingOrder.setStatus(orderRequest.getStatus());
        existingOrder.setNumberOfPeople(orderRequest.getNumberOfPeople());
        existingOrder.setTotalAmount(orderRequest.getTotalAmount());
        existingOrder.setCash(orderRequest.getCash());
        existingOrder.setDescription(orderRequest.getDescription());

        // Save the updated order
        Order updatedOrder = orderRepository.save(existingOrder);

        // Handle order lines
        List<OrderLineDto> updatedOrderLines = orderRequest.getOrderLines().stream()
                .map(orderLineDto -> {
                    if (orderLineDto.getId() != null) {
                        // Update existing order line
                        OrderLine existingOrderLine = orderLineRepository.findById(orderLineDto.getId())
                                .orElseThrow(() -> new IllegalArgumentException("Order line not found"));
                        existingOrderLine.setProductId(orderLineDto.getProductId());
                        existingOrderLine.setPrice(orderLineDto.getPrice());
                        existingOrderLine.setQty(orderLineDto.getQty());
                        existingOrderLine.setAmount(orderLineDto.getAmount());
                        return orderLineRepository.save(existingOrderLine);
                    } else {
                        // Create new order line
                        OrderLine newOrderLine = OrderLineMapper.mapToOrderLine(orderLineDto);
                        newOrderLine.setOrderId(updatedOrder.getId());
                        return orderLineRepository.save(newOrderLine);
                    }
                })
                .map(OrderLineMapper::mapToOrderLineDto)
                .collect(Collectors.toList());

        // Convert back to OrderRequest with updated OrderLines
        return OrderMapper.toRequest(updatedOrder, updatedOrderLines);
    }

    public Long generateUniqueInvoiceNumber() {
        Long invoiceNumber;
        do {
            // Generate a 10-digit number
            invoiceNumber = generate10DigitNumber();
        } while (orderRepository.existsByInvoiceNumber(invoiceNumber));

        return invoiceNumber;
    }

    private Long generate10DigitNumber() {
        // Get the current timestamp in milliseconds (last 7 digits of the timestamp)
        String timestamp = String.valueOf(System.currentTimeMillis()).substring(6); // Last 7 digits

        // Add a random 3-digit number
        Random random = new Random();
        int randomNum = 100 + random.nextInt(900); // Random number between 100 and 999

        // Combine the timestamp and random number
        String combined = timestamp + randomNum;

        // Convert the combined string to Long
        return Long.parseLong(combined);
    }



}
