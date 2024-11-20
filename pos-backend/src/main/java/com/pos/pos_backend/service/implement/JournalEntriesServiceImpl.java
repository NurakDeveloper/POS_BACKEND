package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.accounting.JournalDetailResponse;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.Dto.accounting.JournalEntriesDto;
import com.pos.pos_backend.mapper.accounting.JournalEntriesMapper;
import com.pos.pos_backend.mapper.accounting.TransactionMapper;
import com.pos.pos_backend.model.accounting.JournalEntries;
import com.pos.pos_backend.model.accounting.Transaction;
import com.pos.pos_backend.repository.JournalEntriesRepository;
import com.pos.pos_backend.repository.TransactionRepository;
import com.pos.pos_backend.service.JournalEntriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JournalEntriesServiceImpl implements JournalEntriesService {
    private JournalEntriesRepository journalEntriesRepository;
    private TransactionRepository transactionRepository;


    @Override
    public JournalEntriesDto createJournal(JournalEntriesDto journalEntriesDto) {
        JournalEntries journalEntries = JournalEntriesMapper.maToJournalEntries(journalEntriesDto);
        JournalEntries saveJournal = journalEntriesRepository.save(journalEntries);
        return JournalEntriesMapper.maToJournalEntriesDto(saveJournal);
    }

    @Override
    public JournalDetailResponse getJournalEntriesById(Long id) {
        JournalEntries getJournalEntries = journalEntriesRepository.findById(id).orElseThrow();
        List<Transaction> findTransactionByJournalID = transactionRepository.findAllTransactionByJournalId(getJournalEntries.getId());
        return new JournalDetailResponse(getJournalEntries , findTransactionByJournalID);
    }

    @Override
    public List<JournalEntriesDto> getAllJournalEntries() {
        List<JournalEntries> getAllJournal = journalEntriesRepository.findAll();
        return getAllJournal.stream().map(JournalEntriesMapper::maToJournalEntriesDto).collect(Collectors.toList());
    }

    @Override
    public List<JournalDto> fetchJournal() {
        return journalEntriesRepository.getAllJournal();
    }
}
