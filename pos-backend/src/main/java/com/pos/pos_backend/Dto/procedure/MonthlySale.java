package com.pos.pos_backend.Dto.procedure;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;

// find connect with Journal entity
@Data
@AllArgsConstructor
@SqlResultSetMapping(
        name = "monthlySaleMapping",
        classes = @ConstructorResult(
                targetClass = MonthlySale.class,
                columns = {
                        @ColumnResult(name = "month", type = String.class),
                        @ColumnResult(name = "sales", type = Double.class),

                }
        )
)
public class MonthlySale {
    private String month ;
    private Double sales ;
}
