package com.pos.pos_backend.model.Dto.accounting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long id ;
    private Long journalEntriesId ;
    private Long accountId ;
    private String label ;
    private Double debit ;
    private Double credit ;
}
