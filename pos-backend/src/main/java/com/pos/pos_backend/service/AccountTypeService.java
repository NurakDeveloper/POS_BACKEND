package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.accounting.AccountTypeDto;

import java.util.List;

public interface AccountTypeService {
    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);
    List<AccountTypeDto> getAllAccountType();

}
