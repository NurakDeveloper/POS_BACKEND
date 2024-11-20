package com.pos.pos_backend.repository;

import com.pos.pos_backend.Dto.accounting.AccountDto;
import com.pos.pos_backend.model.accounting.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
