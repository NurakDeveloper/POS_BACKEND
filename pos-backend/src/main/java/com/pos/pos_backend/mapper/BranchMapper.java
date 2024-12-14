package com.pos.pos_backend.mapper;

import com.pos.pos_backend.model.Dto.BranchDto;
import com.pos.pos_backend.model.entity.Branch;

public class BranchMapper {

    public static BranchDto mapToBranchDto(Branch branch) {
        return new BranchDto(
                branch.getId(),
                branch.getBranchName(),
                branch.getBranchCode(),
                branch.getAddressLine1(),
                branch.getAddressLine2(),
                branch.getCity(),
                branch.getState(),
                branch.getPostalCode(),
                branch.getCountry(),
                branch.getPhoneNumber(),
                branch.getEmail(),
                branch.getManagerName(),
                branch.getEstablishedDate(),
                branch.getStatus()

        );
    }
    public static Branch maToBranch(BranchDto branch) {
        return new Branch(
                branch.getId(),
                branch.getBranchName(),
                branch.getBranchCode(),
                branch.getAddressLine1(),
                branch.getAddressLine2(),
                branch.getCity(),
                branch.getState(),
                branch.getPostalCode(),
                branch.getCountry(),
                branch.getPhoneNumber(),
                branch.getEmail(),
                branch.getManagerName(),
                branch.getEstablishedDate(),
                branch.getStatus()

        );
    }


}

