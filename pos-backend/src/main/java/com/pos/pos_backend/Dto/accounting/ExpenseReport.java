package com.pos.pos_backend.Dto.accounting;

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
        name = "expenseMapping",
        classes = @ConstructorResult(
                targetClass = JournalDto.class,
                columns = {
                        @ColumnResult(name = "datejournal", type = String.class),
                        @ColumnResult(name = "totalExpense", type = Double.class),
                        @ColumnResult(name = "reference", type = String.class)
                }
        )
)
public class ExpenseReport {

    private String datejournal;
    private Double totalExpense;
    private String reference;

}
