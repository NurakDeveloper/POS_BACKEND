package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.BranchDto;
import com.pos.pos_backend.mapper.BranchMapper;
import com.pos.pos_backend.model.Branch;
import com.pos.pos_backend.repository.BranchRepository;
import com.pos.pos_backend.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {
    private BranchRepository branchRepository;
    @Override
    public BranchDto createBranch(BranchDto branchDto) {
        Branch branch = BranchMapper.maToBranch(branchDto);
        return BranchMapper.mapToBranchDto(branchRepository.save(branch));
    }

    @Override
    public List<BranchDto> getAllBranch() {
        List<Branch> getAllBranch = branchRepository.findAll();
        return getAllBranch.stream().map(BranchMapper::mapToBranchDto).collect(Collectors.toList());
    }

    @Override
    public BranchDto getBranchByID(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        return BranchMapper.mapToBranchDto(branch);
    }
}
