package com.pos.pos_backend.mapper;


import com.pos.pos_backend.model.Dto.VendorDto;
import com.pos.pos_backend.model.entity.Vendor;

public class VendorMapper {
    public static Vendor toModel(VendorDto dto) {
        Vendor vendor = new Vendor();
        vendor.setId(dto.getId());
        vendor.setDisplayName(dto.getDisplayName());
        vendor.setCompanyName(dto.getCompanyName());
        vendor.setEmail(dto.getEmail());
        vendor.setPhone(dto.getPhone());
        vendor.setAddress(dto.getAddress());
        vendor.setImage(dto.getImage());
        vendor.setActive(dto.getActive());
        return vendor;
    }

    public static VendorDto toDTO(Vendor vendor) {
        VendorDto dto = new VendorDto();
        dto.setId(vendor.getId());
        dto.setDisplayName(vendor.getDisplayName());
        dto.setCompanyName(vendor.getCompanyName());
        dto.setEmail(vendor.getEmail());
        dto.setPhone(vendor.getPhone());
        dto.setAddress(vendor.getAddress());
        dto.setImage(vendor.getImage());
        dto.setActive(vendor.getActive());
        dto.setCreatedDate(vendor.getCreatedDate());
        dto.setUpdatedDate(vendor.getUpdatedDate());
        return dto;
    }
}

