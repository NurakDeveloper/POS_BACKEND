package com.pos.pos_backend.repository;

import com.pos.pos_backend.model.Dto.DateFilter;
import com.pos.pos_backend.model.Dto.accounting.ExpenseReport;
import com.pos.pos_backend.model.Dto.accounting.JournalDto;
import com.pos.pos_backend.model.Dto.procedure.*;

import java.util.List;

public interface CustomizeRepository {
    List<JournalDto> getAllJournalEntries(DateFilter dateFilter);
    List<ExpenseReport> getTotalExpenseReport(DateFilter dateFilter);
    List<ProductSold> getAllProduct();
    List<MonthlySale> getAllMonthlySale();
    List<NetIncome> getNetIncome();
    List<RevenuesReporting> getRevenuesReporting();
    List<ExpenseReporting> getExpenseReporting();
    List<BestSellerDailyProduct> getBestSellerProductDailyReporting();
    List<MonthlySaleReporting> getMonthlySaleReporting();
    List<DailySaleReporting> getDailySaleReporting();
    List<ViewRevenuesByBranch> getViewRevenuesByBranch(Long branchId);
    List<ExpenseByBranches> getViewExpenseByBranch(Long branchId);
    List<ViewIncomeByBranch> getViewIncomeByBranch(Long branchId);

}
