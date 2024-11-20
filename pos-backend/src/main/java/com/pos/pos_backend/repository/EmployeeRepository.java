package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    @Query(value = "select count(*) as TotalEmployee from employee" ,nativeQuery = true)
    Integer countCustomer();

}
