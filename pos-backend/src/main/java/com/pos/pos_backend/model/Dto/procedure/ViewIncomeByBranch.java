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
        name = "viewIncomeByBranches",
        classes = @ConstructorResult(
                targetClass = ViewIncomeByBranch.class,
                columns = {
                        @ColumnResult(name = "branch", type = Long.class),
                        @ColumnResult(name = "date", type = String.class),
                        @ColumnResult(name = "totalRevenue", type = Double.class),
                        @ColumnResult(name = "totalExpenses", type = Double.class),
                        @ColumnResult(name = "income", type = Double.class),
                }
        )
)
public class ViewIncomeByBranch {
    private Long branch ;
    private String date ;
    private Double totalRevenue ;
    private Double totalExpenses ;
    private Double income ;

}
