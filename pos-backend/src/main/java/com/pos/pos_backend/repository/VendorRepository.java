package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor , Long> {
}
