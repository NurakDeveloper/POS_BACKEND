package com.pos.pos_backend.controller.accounting;

import com.pos.pos_backend.model.Dto.accounting.AccountTypeDto;
import com.pos.pos_backend.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/account-type")
@AllArgsConstructor
public class AccountTypeController {
    private AccountTypeService accountTypeService;


    @PostMapping("create")
    public ResponseEntity<AccountTypeDto> createAccountType(@RequestBody AccountTypeDto accountTypeDto){
        AccountTypeDto accountTypeDto1 = accountTypeService.createAccountType(accountTypeDto);

        return new ResponseEntity<>(accountTypeDto1, HttpStatus.CREATED);
    }
    @GetMapping("list-account-type")
    public ResponseEntity<List<AccountTypeDto>> getAll(){
        return ResponseEntity.ok(accountTypeService.getAllAccountType());
    }

}
