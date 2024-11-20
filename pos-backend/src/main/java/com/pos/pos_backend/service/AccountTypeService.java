package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.accounting.AccountTypeDto;

import java.util.List;

public interface AccountTypeService {
    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);
    List<AccountTypeDto> getAllAccountType();

}
