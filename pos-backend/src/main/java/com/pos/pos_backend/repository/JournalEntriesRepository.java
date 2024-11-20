package com.pos.pos_backend.repository;

import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.model.accounting.JournalEntries;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface JournalEntriesRepository extends JpaRepository<JournalEntries , Long>  {
    @Query(value = "CALL getJournal()" ,nativeQuery = true)
    List<JournalDto> getAllJournal();
}
