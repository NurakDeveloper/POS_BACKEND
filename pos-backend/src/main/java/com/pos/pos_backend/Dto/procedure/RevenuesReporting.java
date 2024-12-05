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
        name = "revenuesMappingReport",
        classes = @ConstructorResult(
                targetClass = RevenuesReporting.class,
                columns = {
                        @ColumnResult(name = "month", type = String.class),
                        @ColumnResult(name = "revenuesAccount", type = String.class),
                        @ColumnResult(name = "totalRevnues", type = Double.class),
                        @ColumnResult(name = "description", type = String.class)
                }
        )
)
public class RevenuesReporting {
    private String month ;
    private String revenuesAccount;
    private Double totalRevnues ;
    private String description ;

}
