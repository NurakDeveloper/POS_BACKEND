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
public class BestSellerDailyProduct {
    private String date ;
    private String productName ;
    private Double price ;
    private Integer totalSold ;
    private Double revenues ;
}
