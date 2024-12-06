package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.UserDTO;
import com.pos.pos_backend.mapper.UserMapper;
import com.pos.pos_backend.model.user.User;
import com.pos.pos_backend.repository.UserRepository;
import com.pos.pos_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserDTO> listUser() {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }
}
