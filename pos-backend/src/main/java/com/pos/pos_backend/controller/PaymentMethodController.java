package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.PaymentMethodDto;
import com.pos.pos_backend.service.PaymentMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService service;

    public PaymentMethodController(PaymentMethodService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaymentMethodDto> createPaymentMethod(@RequestBody PaymentMethodDto paymentMethodDto) {
        PaymentMethodDto createdMethod = service.createPaymentMethod(paymentMethodDto);
        return ResponseEntity.ok(createdMethod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethodDto> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethodDto paymentMethodDto) {
        PaymentMethodDto updatedMethod = service.updatePaymentMethod(id, paymentMethodDto);
        return ResponseEntity.ok(updatedMethod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        service.deletePaymentMethod(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodDto> getPaymentMethodById(@PathVariable Long id) {
        PaymentMethodDto paymentMethod = service.getPaymentMethodById(id);
        return ResponseEntity.ok(paymentMethod);
    }

    @GetMapping
    public ResponseEntity<List<PaymentMethodDto>> getAllPaymentMethods() {
        List<PaymentMethodDto> paymentMethods = service.getAllPaymentMethods();
        return ResponseEntity.ok(paymentMethods);
    }
}
