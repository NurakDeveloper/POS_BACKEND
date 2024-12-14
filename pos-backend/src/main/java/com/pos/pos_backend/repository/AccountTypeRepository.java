package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.accounting.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType , Long> {
}
