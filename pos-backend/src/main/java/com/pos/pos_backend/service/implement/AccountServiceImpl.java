package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.accounting.AccountDto;
import com.pos.pos_backend.mapper.accounting.AccountMapper;
import com.pos.pos_backend.model.entity.accounting.Account;
import com.pos.pos_backend.repository.AccountRepository;
import com.pos.pos_backend.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> getAllAccount = accountRepository.findAll();
        return getAllAccount.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }
}
