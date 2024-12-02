package com.pos.pos_backend.repository;

import com.pos.pos_backend.Dto.DateFilter;
import com.pos.pos_backend.Dto.accounting.ExpenseReport;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.Dto.procedure.*;

import java.util.List;

public interface CustomizeRepository {
    List<JournalDto> getAllJournalEntries(DateFilter dateFilter);
    List<ExpenseReport> getTotalExpenseReport(DateFilter dateFilter);
    List<ProductSold> getAllProduct();
    List<MonthlySale> getAllMonthlySale();
    List<NetIncome> getNetIncome();
    List<RevenuesReporting> getRevenuesReporting();
    List<ExpenseReporting> getExpenseReporting();

}
