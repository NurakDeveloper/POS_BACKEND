package com.pos.pos_backend.mapper.orderMapper;

import com.pos.pos_backend.Dto.orderDto.OrderDto;
import com.pos.pos_backend.Dto.orderDto.OrderLineDto;
import com.pos.pos_backend.Dto.orderDto.OrderRequest;
import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
import com.pos.pos_backend.enums.PaymentStatus;
import com.pos.pos_backend.mapper.paymentMapper.PaymentMapper;
import com.pos.pos_backend.model.order.Order;
import com.pos.pos_backend.model.order.OrderLine;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getInvoiceNumber(),
                order.getBranchId(),
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
                order.getDescription(),
                order.getPaymentStatus() != null ? order.getPaymentStatus().toString() : PaymentStatus.PENDING.toString(),
                null // Payments removed
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setInvoiceNumber(orderDto.getInvoiceNumber());
        order.setBranchId(orderDto.getBranchId());
        order.setOrderType(orderDto.getOrderType());
        order.setCustomerId(orderDto.getCustomerId());
        order.setAcceptedBy(orderDto.getAcceptedBy());
        order.setTableNumber(orderDto.getTableNumber());
        order.setStatus(orderDto.getStatus());
        order.setNumberOfPeople(orderDto.getNumberOfPeople());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setCash(orderDto.getCash());
        order.setExchange(orderDto.getExchange());
        order.setOrderDate(orderDto.getOrderDate());
        order.setDescription(orderDto.getDescription());
        order.setPaymentStatus(orderDto.getPaymentStatus() != null ?
                PaymentStatus.valueOf(orderDto.getPaymentStatus()) : PaymentStatus.PENDING);
        return order;
    }
    public static Order toOrder(OrderRequest orderRequest) {
        return new Order(
                orderRequest.getId(),
                orderRequest.getInvoiceNumber(),
                orderRequest.getBranchId(),
                orderRequest.getOrderType(),
                orderRequest.getCustomerId(),
                orderRequest.getAcceptedBy(),
                orderRequest.getTableNumber(),
                orderRequest.getStatus(),
                orderRequest.getNumberOfPeople(),
                orderRequest.getTotalAmount(),
                orderRequest.getCash(),
                orderRequest.getExchange(),
                orderRequest.getOrderDate(),
                orderRequest.getDescription(),
                orderRequest.getPaymentStatus() != null ?
                        PaymentStatus.valueOf(orderRequest.getPaymentStatus()) : PaymentStatus.PENDING
        );
    }

    public static OrderRequest toRequest(Order order, List<OrderLineDto> orderLineDtos) {
        return new OrderRequest(
                order.getId(),
                order.getInvoiceNumber(),
                order.getBranchId(),
                order.getOrderType(),
                order.getCustomerId(),
                order.getAcceptedBy(),
                order.getTableNumber(),
                order.getStatus(),
                order.getNumberOfPeople(),
                order.getTotalAmount(),
                order.getCash(),
                order.getCash() - order.getTotalAmount(), // Dynamically calculate exchange
                order.getOrderDate(),
                order.getDescription(),
                order.getPaymentStatus() != null ? order.getPaymentStatus().toString() : "PENDING",
                orderLineDtos
        );
    }

}
