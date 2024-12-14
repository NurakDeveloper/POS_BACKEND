package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.order.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine , Long> {


    @Query(value = "SELECT * FROM order_line WHERE order_id = ?1", nativeQuery = true)
    List<OrderLine> findAllByOrderID(Long id);
}
