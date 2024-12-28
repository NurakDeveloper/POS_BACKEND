package com.pos.pos_backend.controller;

import com.pos.pos_backend.model.Dto.BranchDto;
import com.pos.pos_backend.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/branches")
@AllArgsConstructor
public class BranchController {

    private  BranchService branchService;


    // Create a new branch
    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("create")
    public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branchDto) {
        BranchDto createdBranch = branchService.createBranch(branchDto);
        return ResponseEntity.ok(createdBranch);
    }

    // Get a branch by ID
    @PreAuthorize("hasAuthority('admin:get')")
    @GetMapping("get/{id}")
    public ResponseEntity<BranchDto> getBranchById(@PathVariable Long id) {
        BranchDto branchDto = branchService.getBranchById(id);
        return branchDto != null ? ResponseEntity.ok(branchDto) : ResponseEntity.notFound().build();
    }

    // Get all branches
    @PreAuthorize("hasAuthority('admin:get')")
    @GetMapping("list-branch")
    public ResponseEntity<List<BranchDto>> getAllBranches() {
        List<BranchDto> branches = branchService.getAllBranches();
        return ResponseEntity.ok(branches);
    }

    // Update an existing branch by ID
    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("update/{id}")
    public ResponseEntity<BranchDto> updateBranch(@PathVariable Long id, @RequestBody BranchDto branchDto) {
        BranchDto updatedBranch = branchService.updateBranch(id, branchDto);
        return updatedBranch != null ? ResponseEntity.ok(updatedBranch) : ResponseEntity.notFound().build();
    }

    // Delete a branch by ID
    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("remove/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
