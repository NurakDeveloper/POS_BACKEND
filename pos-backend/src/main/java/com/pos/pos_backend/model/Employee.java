package com.pos.pos_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    @NotBlank
    String firstName;
    String schedule;
    Long workShiftID;
    Long managerID;
    String cv;
    Long positionID;
    Long companyID;
    String resume;
    Integer dayOff;
    @Email
    String email;
    @Column(unique = true)
    String mobile;
    String gender;
    Double salary;
    String address;
    @Column(unique = true)
    String bankAccount;
    String contact;
    Date startWorkingDate ;
    Date createdDate;
    Date updatedDate ;
    String image;
}

