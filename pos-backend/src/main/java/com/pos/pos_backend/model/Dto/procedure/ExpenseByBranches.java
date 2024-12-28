package com.pos.pos_backend.model.Dto.procedure;

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
        name = "viewExpenseByBranches",
        classes = @ConstructorResult(
                targetClass = ExpenseByBranches.class,
                columns = {
                        @ColumnResult(name = "date", type = String.class),
                        @ColumnResult(name = "accountName", type = String.class),
                        @ColumnResult(name = "type", type = Integer.class),
                        @ColumnResult(name = "credit", type = Double.class),
                        @ColumnResult(name = "debit", type = Double.class),
                        @ColumnResult(name = "branch", type = Integer.class),
                }
        )
)
public class ExpenseByBranches {
    private String date ;
    private String accountName ;
    private Integer type ;
    private Double credit ;
    private Double debit ;
    private Integer branch ;
}
