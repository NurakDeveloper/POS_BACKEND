package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.VendorDto;
import com.pos.pos_backend.mapper.VendorMapper;
import com.pos.pos_backend.model.entity.Vendor;
import com.pos.pos_backend.repository.VendorRepository;
import com.pos.pos_backend.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendorServiceImpl implements VendorService {
    private VendorRepository vendorRepository ;
    @Override
    public VendorDto createVendor(VendorDto vendorDTO) {
        Vendor vendor = VendorMapper.toModel(vendorDTO);
        Vendor savedVendor = vendorRepository.save(vendor);
        return VendorMapper.toDTO(savedVendor);
    }

    @Override
    public VendorDto updateVendor(Long id, VendorDto vendorDTO) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        vendor.setDisplayName(vendorDTO.getDisplayName());
        vendor.setCompanyName(vendorDTO.getCompanyName());
        vendor.setEmail(vendorDTO.getEmail());
        vendor.setPhone(vendorDTO.getPhone());
        vendor.setAddress(vendorDTO.getAddress());
        vendor.setActive(vendorDTO.getActive());
        vendor.setImage(vendorDTO.getImage());
        Vendor updatedVendor = vendorRepository.save(vendor);
        return VendorMapper.toDTO(updatedVendor);
    }

    @Override
    public VendorDto getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        return VendorMapper.toDTO(vendor);
    }

    @Override
    public List<VendorDto> getAllVendors() {
        return vendorRepository.findAll().stream()
                .map(VendorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
