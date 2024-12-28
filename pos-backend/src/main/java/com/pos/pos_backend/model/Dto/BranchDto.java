package com.pos.pos_backend.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {
    private Long id;
    private String branchName;
    private Long managerId ;
    private String branchCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phoneNumber;
    private String email;
    private Date establishedDate;
    private String status;
    private String image ;
}
