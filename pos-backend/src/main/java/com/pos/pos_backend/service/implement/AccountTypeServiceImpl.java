package com.pos.pos_backend.service.implement;


import com.pos.pos_backend.model.Dto.accounting.AccountTypeDto;
import com.pos.pos_backend.mapper.accounting.AccountTypeMapper;
import com.pos.pos_backend.model.entity.accounting.AccountType;
import com.pos.pos_backend.repository.AccountTypeRepository;
import com.pos.pos_backend.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {
    private AccountTypeRepository accountTypeRepository;

    @Override
    public AccountTypeDto createAccountType(AccountTypeDto accountTypeDto) {
        AccountType accountType = AccountTypeMapper.mapToAccountType(accountTypeDto);
        AccountType save = accountTypeRepository.save(accountType);
        return AccountTypeMapper.mapToAccountTypeDto(save);
    }

    @Override
    public List<AccountTypeDto> getAllAccountType() {
        List<AccountType> accountTypes = accountTypeRepository.findAll();
        return accountTypes.stream().map(AccountTypeMapper::mapToAccountTypeDto).collect(Collectors.toList());
    }
}
