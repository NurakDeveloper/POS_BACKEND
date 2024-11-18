package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.accounting.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    List<AccountDto> getAllAccount();

}
