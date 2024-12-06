package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.UserDTO;
import com.pos.pos_backend.model.user.User;

public class UserMapper {
    public static UserDTO mapToUserDto(User user){
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmployeeId(),
                user.getPassword(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }
    public static User mapToUser(UserDTO userDTO){
        return new User(
                userDTO.getUserId(),
                userDTO.getUsername(),
                userDTO.getEmployeeId(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getCreatedDate(),
                userDTO.getUpdatedDate()
        );
    }

}
