package com.pos.pos_backend.repository;

import com.pos.pos_backend.Dto.DateFilter;
import com.pos.pos_backend.Dto.accounting.ExpenseReport;
import com.pos.pos_backend.Dto.accounting.JournalDto;
import com.pos.pos_backend.Dto.procedure.MonthlySale;
import com.pos.pos_backend.Dto.procedure.NetIncome;
import com.pos.pos_backend.Dto.procedure.ProductSold;
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

}
