package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.UserDTO;
import com.pos.pos_backend.model.user.UserRequest;
import com.pos.pos_backend.model.user.UserRespone;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDTO createNewUser(UserDTO userDTO);
    List<UserDTO> listUserByEmployeeId(Long employeeId);
    void removeUser(Long id);

}
