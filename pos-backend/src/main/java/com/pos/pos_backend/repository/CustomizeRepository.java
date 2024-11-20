package com.pos.pos_backend.repository;

import com.pos.pos_backend.Dto.DateFilter;
import com.pos.pos_backend.Dto.accounting.JournalDto;

import java.util.List;

public interface CustomizeRepository {
    List<JournalDto> getAllJournalEntries(DateFilter dateFilter);
}
