package com.pos.pos_backend.controller;

import com.pos.pos_backend.model.Dto.BranchDto;
import com.pos.pos_backend.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branch")
@AllArgsConstructor
@CrossOrigin("*")
public class BranchController {
    private BranchService branchService;

    @PostMapping("create")
    public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branch){
        BranchDto saveBranch = branchService.createBranch(branch);
        return new ResponseEntity<>(saveBranch, HttpStatus.CREATED);
    }
    @GetMapping("list-branch")
    public ResponseEntity<List<BranchDto>> getAllBranch(){
        return ResponseEntity.ok(branchService.getAllBranch());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<BranchDto> getBranchByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(branchService.getBranchByID(id));
    }
}
