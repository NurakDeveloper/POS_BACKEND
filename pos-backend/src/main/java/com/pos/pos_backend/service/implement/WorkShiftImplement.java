package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.WorkShiftDTO;
import com.pos.pos_backend.mapper.WorkShiftMapper;
import com.pos.pos_backend.model.entity.WorkShift;
import com.pos.pos_backend.repository.WorkShiftRepository;
import com.pos.pos_backend.service.WorkShiftService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class WorkShiftImplement implements WorkShiftService {
    private WorkShiftRepository workShiftRepository ;
    @Override
    public WorkShiftDTO createWorkShift(WorkShiftDTO workShiftDTO) {
        WorkShift workShift = WorkShiftMapper.toModel(workShiftDTO);
        return WorkShiftMapper.toDTO(workShiftRepository.save(workShift));
    }

    @Override
    public WorkShiftDTO updateWorkShift(Long id, WorkShiftDTO dto) {
        WorkShift workShift = workShiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkShift not found with id: " + id));

//        existingWorkShift.setStartTime(workShiftDTO.getStartTime());
//        existingWorkShift.setEndTime(workShiftDTO.getEndTime());
//        existingWorkShift.setDescription(workShiftDTO.getDescription());

        workShift.setEmployeeId(dto.getEmployeeId());
        workShift.setShift(dto.getShift());
        workShift.setBranchId(dto.getBranchId());
        workShift.setStartTime(dto.getStartTime());
        workShift.setEndTime(dto.getEndTime());
        workShift.setDescription(dto.getDescription());
        return WorkShiftMapper.toDTO(workShiftRepository.save(workShift));
    }

    @Override
    public void deleteWorkShift(Long id) {
        workShiftRepository.deleteById(id);
    }

    @Override
    public WorkShiftDTO getWorkShiftById(Long id) {
        WorkShift workShift = workShiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkShift not found with id: " + id));
        return WorkShiftMapper.toDTO(workShift);
    }

    @Override
    public List<WorkShiftDTO> getAllWorkShifts() {
        return workShiftRepository.findAll()
                .stream()
                .map(WorkShiftMapper::toDTO)
                .collect(Collectors.toList());
    }
}
