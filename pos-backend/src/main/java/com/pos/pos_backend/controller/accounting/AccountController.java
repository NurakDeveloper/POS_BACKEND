package com.pos.pos_backend.controller.accounting;

import com.pos.pos_backend.Dto.accounting.AccountDto;
import com.pos.pos_backend.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping("create")
    public ResponseEntity<AccountDto> crateAccount(@RequestBody AccountDto accountDto){
        AccountDto createA = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createA, HttpStatus.CREATED);
    }
    @GetMapping("list-account")
    public ResponseEntity<List<AccountDto>> getAll(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }
}
