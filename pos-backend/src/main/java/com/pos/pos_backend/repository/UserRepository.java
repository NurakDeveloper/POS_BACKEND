package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    User findByUserName(String username);
}
