package com.pos.pos_backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDto {
    private Long id;
    private String displayName;
    private String companyName;
    private String email;
    private String phone;
    private String address;
    private Boolean active;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // Getters and Setters
}