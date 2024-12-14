package com.pos.pos_backend.mapper.accounting;

import com.pos.pos_backend.model.Dto.accounting.AccountDto;
import com.pos.pos_backend.model.entity.accounting.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto(Account a){
        return new AccountDto(
                a.getId(),
                a.getAccountTypeId(),
                a.getBranchId(),
                a.getCode(),
                a.getAccountName(),
                a.getCurrency()

        );
    }
    public static Account mapToAccount(AccountDto a){
        return new Account(
                a.getId(),
                a.getAccountTypeId(),
                a.getBranchId(),
                a.getCode(),
                a.getAccountName(),
                a.getCurrency()

        );
    }
}
