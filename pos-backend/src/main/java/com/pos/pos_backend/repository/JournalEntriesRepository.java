package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.Dto.accounting.JournalDto;
import com.pos.pos_backend.model.entity.accounting.JournalEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JournalEntriesRepository extends JpaRepository<JournalEntries , Long>  {
    @Query(value = "CALL getJournal()" ,nativeQuery = true)
    List<JournalDto> getAllJournal();
}
