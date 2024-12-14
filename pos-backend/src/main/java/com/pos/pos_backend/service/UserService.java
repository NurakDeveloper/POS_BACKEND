package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createNewUser(UserDTO userDTO);
    List<UserDTO> listUserByEmployeeId(Long employeeId);
    void removeUser(Long id);

}
