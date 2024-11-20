package com.pos.pos_backend.model.user;

import com.pos.pos_backend.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRespone {
    private String status ;
    private String message ;
    private Long UserId;
    private String Role;
    private Employee data;

}
