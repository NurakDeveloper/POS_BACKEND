package com.pos.pos_backend.repository;

import com.pos.pos_backend.Dto.DateFilter;
import com.pos.pos_backend.Dto.accounting.ExpenseReport;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.Dto.procedure.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomizeImplRepository implements CustomizeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<JournalDto> getAllJournalEntries(DateFilter dateFilter) {
        Query query = entityManager.createNativeQuery("CALL getJournal(:startDate, :endDate)", "JournalDtoMapping");
        query.setParameter("startDate", dateFilter.getStartDate());
        query.setParameter("endDate", dateFilter.getEndDate());
        return query.getResultList();
    }

    @Override
    public List<ExpenseReport> getTotalExpenseReport(DateFilter dateFilter) {
        Query query = entityManager.createNativeQuery("CALL GetTotalExpenseByDateRange(:startDate, :endDate)", "expenseMapping");
        query.setParameter("startDate", dateFilter.getStartDate());
        query.setParameter("endDate", dateFilter.getEndDate());
        return query.getResultList();
    }
    @Override
    public List<ProductSold> getAllProduct() {
        Query query = entityManager.createNativeQuery("CALL productSoldByMonth()", "productSoldMapping");
        return query.getResultList();
    }

    @Override
    public List<MonthlySale> getAllMonthlySale() {
        Query query = entityManager.createNativeQuery("CALL getMonthlySale()", "monthlySaleMapping");
        return query.getResultList();
    }

    @Override
    public List<NetIncome> getNetIncome() {
        Query query = entityManager.createNativeQuery("CALL getNetIncome()", "netIncomeMapping");
        return query.getResultList();
    }

    @Override
    public List<RevenuesReporting> getRevenuesReporting() {
        Query query = entityManager.createNativeQuery("CALL getRevenues()", "revenuesMappingReport");
        return query.getResultList();
    }

    @Override
    public List<ExpenseReporting> getExpenseReporting() {
        Query query = entityManager.createNativeQuery("CALL getExpense()", "expenseMappingReport");
        return query.getResultList();
    }

    @Override
    public List<BestSellerDailyProduct> getBestSellerProductDailyReporting() {
        Query query = entityManager.createNativeQuery("CALL getProductBestSellDaily()", "dailySellProductMapping");
        return query.getResultList();
    }

    @Override
    public List<MonthlySaleReporting> getMonthlySaleReporting() {
        Query query = entityManager.createNativeQuery("CALL getMonthlySale()", "monthlySaleReporting");
        return query.getResultList();
    }

    @Override
    public List<DailySaleReporting> getDailySaleReporting() {
        Query query = entityManager.createNativeQuery("CALL getDailySale()", "dailySaleReporting");
        return query.getResultList();
    }

}
