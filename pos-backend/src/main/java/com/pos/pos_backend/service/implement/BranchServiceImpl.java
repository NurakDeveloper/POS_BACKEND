package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.BranchDto;
import com.pos.pos_backend.mapper.BranchMapper;
import com.pos.pos_backend.model.entity.Branch;
import com.pos.pos_backend.repository.BranchRepository;
import com.pos.pos_backend.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {
    private BranchRepository branchRepository;

    @Override
    public BranchDto createBranch(BranchDto branchDto) {
        Branch branch = BranchMapper.maToBranch(branchDto);
        Branch savedBranch = branchRepository.save(branch);
        return BranchMapper.mapToBranchDto(savedBranch);
    }

    @Override
    public BranchDto getBranchById(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow();
        return BranchMapper.mapToBranchDto(branch); // or throw an exception
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(BranchMapper::mapToBranchDto)
                .collect(Collectors.toList());
    }

    @Override
    public BranchDto updateBranch(Long id, BranchDto branchDto) {
        Optional<Branch> existingBranchOpt = branchRepository.findById(id);

        if (existingBranchOpt.isPresent()) {
            Branch existingBranch = existingBranchOpt.get();

            // Only update the fields that are not null in the DTO
            if (branchDto.getBranchName() != null) existingBranch.setBranchName(branchDto.getBranchName());
            if (branchDto.getManagerId() != null) existingBranch.setManagerId(branchDto.getManagerId());
            if (branchDto.getBranchCode() != null) existingBranch.setBranchCode(branchDto.getBranchCode());
            if (branchDto.getAddressLine1() != null) existingBranch.setAddressLine1(branchDto.getAddressLine1());
            if (branchDto.getAddressLine2() != null) existingBranch.setAddressLine2(branchDto.getAddressLine2());
            if (branchDto.getCity() != null) existingBranch.setCity(branchDto.getCity());
            if (branchDto.getState() != null) existingBranch.setState(branchDto.getState());
            if (branchDto.getPostalCode() != null) existingBranch.setPostalCode(branchDto.getPostalCode());
            if (branchDto.getCountry() != null) existingBranch.setCountry(branchDto.getCountry());
            if (branchDto.getPhoneNumber() != null) existingBranch.setPhoneNumber(branchDto.getPhoneNumber());
            if (branchDto.getEmail() != null) existingBranch.setEmail(branchDto.getEmail());
            if (branchDto.getEstablishedDate() != null)
                existingBranch.setEstablishedDate(branchDto.getEstablishedDate());
            if (branchDto.getStatus() != null) existingBranch.setStatus(branchDto.getStatus());
            if (branchDto.getImage() != null) existingBranch.setImage(branchDto.getImage());

            Branch updatedBranch = branchRepository.save(existingBranch);
            return BranchMapper.mapToBranchDto(updatedBranch);
        }
        return null;
    }
    @Override
    public void deleteBranch(Long id) {
        if (branchRepository.existsById(id)) {
            branchRepository.deleteById(id);
        }
        // else, throw an exception if needed
    }
}
