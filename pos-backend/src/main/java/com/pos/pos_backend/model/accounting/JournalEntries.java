package com.pos.pos_backend.model.accounting;

import com.pos.pos_backend.Dto.accounting.ExpenseReport;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JournalEntries")
@SqlResultSetMapping(
        name = "JournalDtoMapping",
        classes = @ConstructorResult(
                targetClass = JournalDto.class,
                columns = {
                        @ColumnResult(name = "accountingDate", type = String.class),
                        @ColumnResult(name = "accountName", type = String.class),
                        @ColumnResult(name = "totalDebit", type = Double.class),
                        @ColumnResult(name = "totalCredit", type = Double.class)
                }
        )
)
@SqlResultSetMapping(
        name = "expenseMapping",
        classes = @ConstructorResult(
                targetClass = ExpenseReport.class,
                columns = {
                        @ColumnResult(name = "datejournal", type = String.class),
                        @ColumnResult(name = "totalExpense", type = Double.class),
                        @ColumnResult(name = "reference", type = String.class),
                }
        )
)
public class JournalEntries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String journal ;
    private Long branchId ;
    private Long partnerId;
    private Date date ;
    private Double total ;
    private String reference ;
    private String status ;



}
