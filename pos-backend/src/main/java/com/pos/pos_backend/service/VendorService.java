package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.VendorDto;

import java.util.List;

public interface VendorService {

    VendorDto createVendor(VendorDto vendorDTO);
    VendorDto updateVendor(Long id, VendorDto vendorDTO);
    VendorDto getVendorById(Long id);
    List<VendorDto> getAllVendors();
    void deleteVendor(Long id);
}
