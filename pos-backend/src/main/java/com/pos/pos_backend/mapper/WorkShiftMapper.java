package com.pos.pos_backend.mapper;

import com.pos.pos_backend.model.Dto.WorkShiftDTO;
import com.pos.pos_backend.model.entity.WorkShift;

public class WorkShiftMapper {
    public static WorkShift toModel(WorkShiftDTO dto) {
        WorkShift workShift = new WorkShift();
        workShift.setId(dto.getId());
        workShift.setShiftName(dto.getShiftName());
        workShift.setStartTime(dto.getStartTime());
        workShift.setEndTime(dto.getEndTime());
        workShift.setDescription(dto.getDescription());
        return workShift;
    }

    public static WorkShiftDTO toDTO(WorkShift workShift) {
        WorkShiftDTO dto = new WorkShiftDTO();
        dto.setId(workShift.getId());
        dto.setShiftName(workShift.getShiftName());
        dto.setStartTime(workShift.getStartTime());
        dto.setEndTime(workShift.getEndTime());
        dto.setDescription(workShift.getDescription());
        dto.setCreatedDate(workShift.getCreatedDate());
        dto.setUpdatedDate(workShift.getUpdatedDate());
        return dto;
    }
}

