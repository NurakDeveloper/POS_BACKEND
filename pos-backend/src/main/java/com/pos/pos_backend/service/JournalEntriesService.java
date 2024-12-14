package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.accounting.JournalDetailResponse;
import com.pos.pos_backend.model.Dto.accounting.JournalDto;
import com.pos.pos_backend.model.Dto.accounting.JournalEntriesDto;

import java.util.List;


public interface JournalEntriesService {
    JournalEntriesDto createJournal(JournalEntriesDto journalEntriesDto);
    JournalDetailResponse getJournalEntriesById(Long id);
    List<JournalEntriesDto> getAllJournalEntries();
    List<JournalDto> fetchJournal();
}
