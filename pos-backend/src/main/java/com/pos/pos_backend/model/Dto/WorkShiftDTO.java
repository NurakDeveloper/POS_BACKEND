package com.pos.pos_backend.model.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkShiftDTO {
    private Long id;
    private String shiftName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // Getters and Setters
}

