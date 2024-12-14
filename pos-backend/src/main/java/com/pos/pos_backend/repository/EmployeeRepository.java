package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    @Query(value = "select count(*) as TotalEmployee from employee" ,nativeQuery = true)
    Integer countCustomer();

    @Query(value = "select * from employee where id = ?1" , nativeQuery = true)
    Employee getEmployee(Long id);

}
