package com.pos.pos_backend.mapper.accounting;

import com.pos.pos_backend.model.Dto.accounting.AccountTypeDto;
import com.pos.pos_backend.model.entity.accounting.AccountType;

public class AccountTypeMapper {
    public static AccountTypeDto mapToAccountTypeDto(AccountType a){
        return new AccountTypeDto(
                a.getId(),
                a.getAccountType(),
                a.getNote(),
                a.getCreatedDate()
        );
    }
    public static AccountType mapToAccountType(AccountTypeDto a){
        return new AccountType(
                a.getId(),
                a.getAccountType(),
                a.getNote(),
                a.getCreatedDate()
        );
    }
}
