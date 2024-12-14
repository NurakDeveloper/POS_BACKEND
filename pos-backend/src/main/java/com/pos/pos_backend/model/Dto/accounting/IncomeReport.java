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
        name = "incomeMapping",
        classes = @ConstructorResult(
                targetClass = IncomeReport.class,
                columns = {
                        @ColumnResult(name = "datejournal", type = String.class),
                        @ColumnResult(name = "totalIncome", type = Double.class),
                        @ColumnResult(name = "reference", type = String.class)
                }
        )
)
public class IncomeReport {

    private String datejournal;
    private Double totalIncome;
    private String reference;

}
