    package com.pos.pos_backend.service;

    import com.pos.pos_backend.Dto.orderDto.OrderDto;
    import com.pos.pos_backend.Dto.paymentDto.PaymentDto;
    import com.pos.pos_backend.enums.PaymentStatus;

    import java.util.Date;
    import java.util.List;

    public interface OrderService {
        OrderDto createOrder(OrderDto orderDto);
        List<OrderDto> getAllOrder();
        OrderDto getOrderByID(Long orderId);
        Double totalOrderToday(Date date);

        PaymentDto addPayment(Long orderId, PaymentDto paymentDto);

        OrderDto addPaymentToOrder(Long orderId, Double amountPaid, String paymentMethod); // New method

        void updateOrderPaymentStatus(Long orderId, PaymentStatus paymentStatus);

    }
