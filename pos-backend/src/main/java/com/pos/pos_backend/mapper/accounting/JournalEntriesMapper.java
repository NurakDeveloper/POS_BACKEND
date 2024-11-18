package com.pos.pos_backend.mapper.accounting;

import com.pos.pos_backend.Dto.accounting.JournalEntriesDto;
import com.pos.pos_backend.model.accounting.JournalEntries;

public class JournalEntriesMapper {
    public static JournalEntriesDto maToJournalEntriesDto(JournalEntries j){
        return new JournalEntriesDto(
                j.getId(),
                j.getJournal(),
                j.getBranchId(),
                j.getPartnerId(),
                j.getDate(),
                j.getTotal(),
                j.getReference(),
                j.getStatus()
        );
    }
    public static JournalEntries maToJournalEntries(JournalEntriesDto j){
        return new JournalEntries(
                j.getId(),
                j.getJournal(),
                j.getBranchId(),
                j.getPartnerId(),
                j.getDate(),
                j.getTotal(),
                j.getReference(),
                j.getStatus()
        );
    }
}
