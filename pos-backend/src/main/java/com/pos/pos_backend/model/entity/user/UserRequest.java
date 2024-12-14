package com.pos.pos_backend.model.entity.user;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
}
