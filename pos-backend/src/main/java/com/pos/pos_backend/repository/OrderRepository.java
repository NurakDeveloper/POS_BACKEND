package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order , Long> {
    @Query(value = "SELECT sum(total_amount) FROM orders WHERE DATE(order_date) = ?1",nativeQuery = true)
    Double findTotalOrderToday(String date);
}
