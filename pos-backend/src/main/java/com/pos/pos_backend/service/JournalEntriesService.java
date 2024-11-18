package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.accounting.JournalDetailResponse;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.Dto.accounting.JournalEntriesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface JournalEntriesService {
    JournalEntriesDto createJournal(JournalEntriesDto journalEntriesDto);
    JournalDetailResponse getJournalEntriesById(Long id);
    List<JournalEntriesDto> getAllJournalEntries();
    List<JournalDto> fetchJournal();
}
