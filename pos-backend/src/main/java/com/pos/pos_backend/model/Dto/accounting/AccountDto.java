package com.pos.pos_backend.model.Dto.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private Long accountTypeId;
    private Long branchId;
    private Integer code ;
    private String accountName ;
    private String currency;
}
