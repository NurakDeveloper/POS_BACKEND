package com.pos.pos_backend.controller.accounting;

import com.pos.pos_backend.model.Dto.accounting.TransactionDto;

import com.pos.pos_backend.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/transaction")
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping("create")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
        TransactionDto transactionDto1 = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(transactionDto1, HttpStatus.CREATED);
    }

    @GetMapping("list-by/{id}")
    public ResponseEntity<List<TransactionDto>> getAllTransactionByJournalEId(@PathVariable("id") Long id){
        return ResponseEntity.ok(transactionService.getTransactionByJournalEId(id));
    }
}
