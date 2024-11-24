package com.pos.pos_backend.controller.accounting;

import com.pos.pos_backend.Dto.DateFilter;
import com.pos.pos_backend.Dto.accounting.ExpenseReport;
import com.pos.pos_backend.Dto.accounting.JournalDetailResponse;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.Dto.accounting.JournalEntriesDto;
import com.pos.pos_backend.repository.CustomizeRepository;
import com.pos.pos_backend.service.JournalEntriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/journal")
@AllArgsConstructor
public class JournalEController {
    private JournalEntriesService journalEntriesService;
    private CustomizeRepository customizeRepoJournal;

    @PostMapping("create")
    public ResponseEntity<JournalEntriesDto> createJournalE(@RequestBody JournalEntriesDto journalEntriesDto){
        JournalEntriesDto journal = journalEntriesService.createJournal(journalEntriesDto);
        return new ResponseEntity<>(journal , HttpStatus.CREATED);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<JournalDetailResponse> getJournalById(@PathVariable("id") Long id){
        return ResponseEntity.ok(journalEntriesService.getJournalEntriesById(id));
    }
    @GetMapping("list-journal")
    public ResponseEntity<List<JournalEntriesDto>> getAllJournal(){
        return ResponseEntity.ok(journalEntriesService.getAllJournalEntries());
    }
    @PostMapping("fetch-journal")
    public ResponseEntity<List<JournalDto>> getAllJournals(@RequestBody DateFilter dateFilter) {
        return ResponseEntity.ok(customizeRepoJournal.getAllJournalEntries(dateFilter));
    }
    @PostMapping("report-expense")
    public ResponseEntity<List<ExpenseReport>> getTotalExpenseReport(@RequestBody DateFilter dateFilter) {
        return ResponseEntity.ok(customizeRepoJournal.getTotalExpenseReport(dateFilter));
    }
}
