package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.accounting.TransactionDto;
import com.pos.pos_backend.mapper.accounting.TransactionMapper;
import com.pos.pos_backend.model.entity.accounting.Transaction;
import com.pos.pos_backend.repository.TransactionRepository;
import com.pos.pos_backend.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.mapTransaction(transactionDto);
        Transaction save = transactionRepository.save(transaction);
        return TransactionMapper.mapTransactionDto(save);
    }

    @Override
    public List<TransactionDto> getTransactionByJournalEId(Long id) {
        List<Transaction> getAllTransactionByJournalEId = transactionRepository.findAllTransactionByJournalId(id);
        return getAllTransactionByJournalEId.stream().map(TransactionMapper::mapTransactionDto).collect(Collectors.toList());
    }
}
