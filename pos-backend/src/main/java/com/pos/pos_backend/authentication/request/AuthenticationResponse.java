package com.pos.pos_backend.authentication.request;

import com.pos.pos_backend.model.entity.Employee;
import com.pos.pos_backend.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Long userId;
    private String username;
    private String role;
    private Employee data;
    private List<String> permissions;
}
