package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkShiftRepository extends JpaRepository<WorkShift , Long> {
}