package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.VendorDto;
import com.pos.pos_backend.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/vendor")
@AllArgsConstructor
public class VendorController {
    private VendorService vendorService ;

    @PostMapping("create")
    public ResponseEntity<VendorDto> createVendor(@RequestBody VendorDto vendorDTO) {
        return ResponseEntity.ok(vendorService.createVendor(vendorDTO));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<VendorDto> updateVendor(@PathVariable Long id, @RequestBody VendorDto vendorDTO) {
        return ResponseEntity.ok(vendorService.updateVendor(id, vendorDTO));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<VendorDto> getVendorById(@PathVariable Long id) {
        return ResponseEntity.ok(vendorService.getVendorById(id));
    }

    @GetMapping("list-vendor")
    public ResponseEntity<List<VendorDto>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok("Remove Success !");
    }
}
