package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.Product;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product , Long> {

}
