package com.pos.pos_backend.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateFilter {
    private String startDate ;
    private String endDate ;
}
