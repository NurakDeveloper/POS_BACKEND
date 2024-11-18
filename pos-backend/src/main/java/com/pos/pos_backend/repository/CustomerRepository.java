package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long> {
}
