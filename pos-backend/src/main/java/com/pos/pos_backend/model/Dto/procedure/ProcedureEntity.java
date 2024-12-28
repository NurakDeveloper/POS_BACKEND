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
@SqlResultSetMapping(
        name = "viewRevenuesByBranches",
        classes = @ConstructorResult(
                targetClass = ViewRevenuesByBranch.class,
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
public class ProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
