package com.pos.pos_backend.controller.reporting;

import com.pos.pos_backend.Dto.procedure.*;
import com.pos.pos_backend.repository.CustomizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/reporting")
@AllArgsConstructor
public class ReportController {
    private CustomizeRepository customizeRepository;

    // find monthly sale report
//    @GetMapping("monthly-sale")
//    public ResponseEntity<List<MonthlySale>> getMonthlySaleReporting(){
//        return ResponseEntity.ok(customizeRepository.getAllMonthlySale());
//    }

    // find net income report

    @GetMapping("net-income")
    public ResponseEntity<List<NetIncome>> netIncome(){
        return ResponseEntity.ok(customizeRepository.getNetIncome());
    }

    // Get Expense reporting from store procedure
    @GetMapping("expense")
    public ResponseEntity<List<ExpenseReporting>> getExpense(){
        return ResponseEntity.ok(customizeRepository.getExpenseReporting());
    }
    // Get Revenues reporting from store procedure
    @GetMapping("revenues")
    public ResponseEntity<List<RevenuesReporting>> getRevenues(){
        return ResponseEntity.ok(customizeRepository.getRevenuesReporting());
    }
    @GetMapping("daily-seller-product")
    public ResponseEntity<List<BestSellerDailyProduct>> getBestSellerProductDaily(){
        return ResponseEntity.ok(customizeRepository.getBestSellerProductDailyReporting());
    }
    @GetMapping("monthly-sale")
    public ResponseEntity<List<MonthlySaleReporting>> getMonthlySaleReport(){
        return ResponseEntity.ok(customizeRepository.getMonthlySaleReporting());
    }
    @GetMapping("daily-sale")
    public ResponseEntity<List<DailySaleReporting>> getDailySaleReporting(){
        return ResponseEntity.ok(customizeRepository.getDailySaleReporting());
    }


}
