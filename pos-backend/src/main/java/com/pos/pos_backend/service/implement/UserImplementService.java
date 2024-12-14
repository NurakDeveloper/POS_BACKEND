package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.UserDTO;
import com.pos.pos_backend.mapper.UserMapper;
import com.pos.pos_backend.model.entity.user.User;
import com.pos.pos_backend.repository.UserRepository;
import com.pos.pos_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserImplementService implements UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User saveUser = userRepository.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public List<UserDTO> listUserByEmployeeId(Long employeeId) {
        List<User> user = userRepository.findUserByEmployeeId(employeeId);
        return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }


    @Override
    public void removeUser(Long id) {

    }
}
