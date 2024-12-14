package com.pos.pos_backend.model.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    private Long id;
    private Long categoryId;
    private Long createdBy;
    private Long updatedBy;
    private String productName;
    private Double price;
    private String prepareTime;
    private String description;
    private Integer calories;
    private Integer status;
    private String productOrigin;
    private Integer sugar;
    private String image;
    private Integer maxOrderQty;
    private Integer minOrderQty;
    private Long branchId;
    private Date createdDate;
    private Date updatedDate;
}
