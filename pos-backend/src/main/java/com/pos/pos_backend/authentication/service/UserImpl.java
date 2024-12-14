package com.pos.pos_backend.authentication.service;

import com.pos.pos_backend.model.entity.user.User;
import com.pos.pos_backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserDetailsService{
    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }


}
