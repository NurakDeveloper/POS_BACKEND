package com.pos.pos_backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id ;
    private Long createdBy ;
    private Long updatedBy ;
    private Long categoryId;
    private Long branchId ;
    private Long productCode ;
    private String productName ;
    private Double price ;
    private String prepareTime ;
    private String description ;
    private Integer calories;
    private Integer status ;
    private String productOrigin;
    private Integer sugar;
    private String image ;
    private Integer maxOrderQty ;
    private Integer minOrderQty ;
    private Date createdDate ;
    private Date updatedDate ;
}