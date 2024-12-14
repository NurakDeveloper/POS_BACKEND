package com.pos.pos_backend.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String schedule;
    private Long workShiftID;
    private Long managerID;
    private String cv;
    private Long positionID;
    private Long companyID;
    private String resume;
    private Integer dayOff;
    private String email;
    private String mobile;
    private String gender;
    private Double salary;
    private String address;
    private String bankAccount;
    private String contact;
    private Date startWorkingDate ;
    private Date createdDate;
    private Date updatedDate ;
    private String image;
}
