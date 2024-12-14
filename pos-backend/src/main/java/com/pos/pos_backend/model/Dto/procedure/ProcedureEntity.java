package com.pos.pos_backend.model.Dto.procedure;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "procedureEntity")
@SqlResultSetMapping(
        name = "dailySellProductMapping",
        classes = @ConstructorResult(
                targetClass = BestSellerDailyProduct.class,
                columns = {
                        @ColumnResult(name = "date", type = String.class),
                        @ColumnResult(name = "productName", type = String.class),
                        @ColumnResult(name = "price", type = Double.class),
                        @ColumnResult(name = "totalSold", type = Integer.class),
                        @ColumnResult(name = "revenues", type = Double.class)
                }
        )
)
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
@SqlResultSetMapping(
        name = "dailySaleReporting",
        classes = @ConstructorResult(
                targetClass = DailySaleReporting.class,
                columns = {
                        @ColumnResult(name = "date", type = String.class),
                        @ColumnResult(name = "sold", type = Integer.class),
                        @ColumnResult(name = "revenues", type = Double.class),
                }
        )
)
public class ProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
