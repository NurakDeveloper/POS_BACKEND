package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.accounting.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
