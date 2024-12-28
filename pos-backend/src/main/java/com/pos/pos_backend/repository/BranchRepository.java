package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch , Long> {
    @Query( value = "select * from branch where id = ?1" ,nativeQuery = true)
    Branch getBranch(Long branchId);
}
