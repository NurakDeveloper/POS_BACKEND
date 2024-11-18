package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch , Long> {
}
