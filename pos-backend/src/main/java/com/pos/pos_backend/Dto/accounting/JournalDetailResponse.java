package com.pos.pos_backend.Dto.accounting;

import com.pos.pos_backend.model.accounting.JournalEntries;
import com.pos.pos_backend.model.accounting.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JournalDetailResponse {
    private JournalEntries journalEntries ;
    private List<Transaction> transactions;
}
