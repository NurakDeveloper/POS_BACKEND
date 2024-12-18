package com.pos.pos_backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long createdBy;
    private Long updatedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // Many products belong to one category
    @Column(nullable = false)
    private Long branchId;
    @Column(nullable = false)
    private Long productCode;
    @Column(nullable = false)
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
    private Date createdDate;
    private Date updatedDate;
}
