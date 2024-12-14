package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.orderDto.OrderRequest;

public interface OrderServiceMulti {
    OrderRequest orderRequest(OrderRequest orderRequest);
}
