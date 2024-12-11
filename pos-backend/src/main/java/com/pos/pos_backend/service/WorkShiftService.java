package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.WorkShiftDTO;

import java.util.List;

public interface WorkShiftService {
    WorkShiftDTO createWorkShift(WorkShiftDTO workShiftDTO);
    WorkShiftDTO updateWorkShift(Long id, WorkShiftDTO workShiftDTO);
    void deleteWorkShift(Long id);
    WorkShiftDTO getWorkShiftById(Long id);
    List<WorkShiftDTO> getAllWorkShifts();
}
