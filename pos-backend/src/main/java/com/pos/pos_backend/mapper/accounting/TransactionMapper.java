package com.pos.pos_backend.mapper.accounting;

import com.pos.pos_backend.Dto.accounting.TransactionDto;
import com.pos.pos_backend.model.accounting.Transaction;

public class TransactionMapper {
    public static TransactionDto mapTransactionDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getJournalEntriesId(),
                transaction.getAccountId(),
                transaction.getLabel(),
                transaction.getDebit(),
                transaction.getCredit()
        );
    }
    public static Transaction mapTransaction(TransactionDto transaction){
        return new Transaction(
                transaction.getId(),
                transaction.getJournalEntriesId(),
                transaction.getAccountId(),
                transaction.getLabel(),
                transaction.getDebit(),
                transaction.getCredit()
        );
    }
}
