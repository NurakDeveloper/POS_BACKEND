package com.pos.pos_backend.model.Dto.accounting;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name = "JournalDtoMapping",
        classes = @ConstructorResult(
                targetClass = JournalDto.class,
                columns = {
                        @ColumnResult(name = "accountingDate", type = String.class),
                        @ColumnResult(name = "accountName", type = String.class),
                        @ColumnResult(name = "totalDebit", type = Double.class),
                        @ColumnResult(name = "totalCredit", type = Double.class)
                }
        )
)
public class JournalDto {
    private String accountingDate;
    private String accountName;
    private Double totalDebit;
    private Double totalCredit;
}

