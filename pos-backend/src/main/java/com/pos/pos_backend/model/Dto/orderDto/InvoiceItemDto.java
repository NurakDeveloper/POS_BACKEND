package com.pos.pos_backend.model.Dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceItemDto {
    private String productName ;
    private Double price ;
    private Integer qty ;
    private Double amount ;
}
