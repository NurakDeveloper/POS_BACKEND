package com.pos.pos_backend.model.Dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {
    private Long id ;
    private Long orderId ;
    private Long productId ;
    private Double price ;
    private Integer qty ;
    private Double amount ;
}
