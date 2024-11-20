package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.accounting.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> getTransactionByJournalEId(Long id);
}
