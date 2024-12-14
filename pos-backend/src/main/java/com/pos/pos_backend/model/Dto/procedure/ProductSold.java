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
        name = "productSoldMapping",
        classes = @ConstructorResult(
                targetClass = ProductSold.class,
                columns = {
                        @ColumnResult(name = "orderDate", type = String.class),
                        @ColumnResult(name = "product", type = String.class),
                        @ColumnResult(name = "sold", type = Integer.class)
                }
        )
)
public class ProductSold {
    private String orderDate ;
    private String product ;
    private Integer sold;
}
