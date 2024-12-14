package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.accounting.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    List<AccountDto> getAllAccount();

}
