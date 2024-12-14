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
        name = "monthlySaleReporting",
        classes = @ConstructorResult(
                targetClass = MonthlySaleReporting.class,
                columns = {
                        @ColumnResult(name = "date", type = String.class),
                        @ColumnResult(name = "sold", type = Integer.class),
                        @ColumnResult(name = "revenues", type = Double.class),
                }
        )
)
public class MonthlySaleReporting {

    private String date ;
    private Integer sold ;
    private Double revenues ;
}
