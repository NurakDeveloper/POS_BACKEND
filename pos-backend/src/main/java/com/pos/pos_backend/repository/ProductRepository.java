package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {

}
