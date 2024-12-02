package com.pos.pos_backend.Dto.procedure;

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
        name = "expenseMappingReport",
        classes = @ConstructorResult(
                targetClass = ExpenseReporting.class,
                columns = {
                        @ColumnResult(name = "month", type = String.class),
                        @ColumnResult(name = "expenseAccount", type = String.class),
                        @ColumnResult(name = "totalExpense", type = Double.class),
                        @ColumnResult(name = "description", type = String.class)
                }
        )
)
public class ExpenseReporting {
    private String month ;
    private String expenseAccount;
    private Double totalExpense ;
    private String description ;

}
