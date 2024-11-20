package com.pos.pos_backend.model.order;

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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long invoiceNumber ;
    private Long orderType ;
    private Long customerId ;
    private Long acceptedBy ;
    private Integer tableNumber ;
    private Integer status ;
    private Integer numberOfPeople ;
    private Double totalAmount ;
    private Double cash ;
    private Double exchange ;
    private Date orderDate ;
    private String description ;


}
