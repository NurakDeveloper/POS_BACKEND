package com.pos.pos_backend.service;

import com.pos.pos_backend.model.user.UserRequest;
import com.pos.pos_backend.model.user.UserRespone;

public interface UserService {
    UserRespone userLogin(UserRequest userRequest);
}
