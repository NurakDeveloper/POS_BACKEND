package com.pos.pos_backend.model.Dto.procedure;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@SqlResultSetMapping(
        name = "netIncomeMapping",
        classes = @ConstructorResult(
                targetClass = NetIncome.class,
                columns = {
                        @ColumnResult(name = "month", type = String.class),
                        @ColumnResult(name = "totalRevenues", type = Double.class),
                        @ColumnResult(name = "totalExpense", type = Double.class),
                        @ColumnResult(name = "netIncome", type = Double.class),

                }
        )
)
public class NetIncome {
    private String month ;
    private Double totalRevenues ;
    private Double totalExpense ;
    private Double netIncome ;
}
