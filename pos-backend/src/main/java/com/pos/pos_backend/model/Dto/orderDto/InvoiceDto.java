package com.pos.pos_backend.model.Dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private String invoiceNumber ;
    private String customerName ;
    private Date invoiceDate ;
    private String stuff ;
    private String branchName ;
    private String branchPhoneNumber ;
    private String branchAddress ;
    private String paymentStatus ;
    private String paymentMethod ;
    private Double received ;
    private Double totalAmount ;
    private Double totalDiscount ;
    private Double change ;
    private List<InvoiceItemDto> invoiceItemDto ;


}
