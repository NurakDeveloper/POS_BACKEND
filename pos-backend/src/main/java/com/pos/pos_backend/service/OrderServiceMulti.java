package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.orderDto.InvoiceDto;
import com.pos.pos_backend.model.Dto.orderDto.OrderRequest;

public interface OrderServiceMulti {
    OrderRequest orderRequest(OrderRequest orderRequest);
    InvoiceDto sale(OrderRequest orderRequest);
    OrderRequest updateOrder (Long id , OrderRequest orderRequest);
}
