package com.pos.pos_backend.Dto.accounting;

import jakarta.persistence.Column;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntriesDto {
    private Long id ;
    private String journal ;
    private Long branchId ;
    private Long partnerId;
    @Column(nullable = false)
    private Date date ;
    private Double total ;
    private String reference ;
    private String status ;
}
