package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.BranchDto;

import java.util.List;

public interface BranchService {
    BranchDto createBranch(BranchDto branchDto);
    List<BranchDto> getAllBranch();
    BranchDto getBranchByID(Long id);

}
