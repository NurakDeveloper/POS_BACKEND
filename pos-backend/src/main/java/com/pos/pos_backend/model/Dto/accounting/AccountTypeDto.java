package com.pos.pos_backend.model.Dto.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTypeDto {
    private Long id ;
    private String accountType ;
    private String note ;
    private Date createdDate ;
}
