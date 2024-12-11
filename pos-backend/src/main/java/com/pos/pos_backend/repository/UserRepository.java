package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Long> {
    User findByUsername(String username);

    @Query(value = "select * from users where employee_id = ?1" , nativeQuery = true)
    List<User> findUserByEmployeeId(Long id);
}
