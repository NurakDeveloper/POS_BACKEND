package com.pos.pos_backend.model.entity.user;

import com.pos.pos_backend.model.entity.Employee;
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
    private String token ;
    private Long UserId;
    private String Role;
    private Employee data;

}
