package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.WorkShiftDTO;
import com.pos.pos_backend.service.WorkShiftService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/work-shift")
@AllArgsConstructor
public class WorkShiftController {
    private WorkShiftService service;
    @PostMapping("create")
    public ResponseEntity<WorkShiftDTO> createWorkShift(@RequestBody WorkShiftDTO workShiftDTO) {
        return ResponseEntity.ok(service.createWorkShift(workShiftDTO));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<WorkShiftDTO> updateWorkShift(@PathVariable Long id, @RequestBody WorkShiftDTO workShiftDTO) {
        return ResponseEntity.ok(service.updateWorkShift(id, workShiftDTO));
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<Void> deleteWorkShift(@PathVariable Long id) {
        service.deleteWorkShift(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<WorkShiftDTO> getWorkShiftById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getWorkShiftById(id));
    }

    @GetMapping("list-work-shift")
    public ResponseEntity<List<WorkShiftDTO>> getAllWorkShifts() {
        return ResponseEntity.ok(service.getAllWorkShifts());
    }
}
