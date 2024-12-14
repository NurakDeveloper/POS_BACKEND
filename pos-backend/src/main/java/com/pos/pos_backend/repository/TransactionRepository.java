package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.entity.accounting.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {
    @Query( value = "select * from transaction where journal_entries_id = ?1",nativeQuery = true)
    List<Transaction> findAllTransactionByJournalId(Long id);
}
