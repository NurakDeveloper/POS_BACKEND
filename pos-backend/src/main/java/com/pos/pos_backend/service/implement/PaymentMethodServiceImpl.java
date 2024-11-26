package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.PaymentMethodDto;
import com.pos.pos_backend.mapper.PaymentMethodMapper;
import com.pos.pos_backend.model.PaymentMethod;
import com.pos.pos_backend.repository.PaymentMethodRepository;
import com.pos.pos_backend.service.PaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository repository;
    private final PaymentMethodMapper mapper;

    public PaymentMethodServiceImpl(PaymentMethodRepository repository, PaymentMethodMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PaymentMethodDto createPaymentMethod(PaymentMethodDto paymentMethodDto) {
        if (repository.existsByName(paymentMethodDto.getName())) {
            throw new IllegalArgumentException("Payment method already exists");
        }
        PaymentMethod paymentMethod = mapper.toEntity(paymentMethodDto);
        PaymentMethod savedPaymentMethod = repository.save(paymentMethod);
        return mapper.toDto(savedPaymentMethod);
    }

    @Override
    public PaymentMethodDto updatePaymentMethod(Long id, PaymentMethodDto paymentMethodDto) {
        PaymentMethod existingPaymentMethod = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment method not found"));
        existingPaymentMethod.setName(paymentMethodDto.getName());
        PaymentMethod updatedPaymentMethod = repository.save(existingPaymentMethod);
        return mapper.toDto(updatedPaymentMethod);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Payment method not found");
        }
        repository.deleteById(id);
    }

    @Override
    public PaymentMethodDto getPaymentMethodById(Long id) {
        PaymentMethod paymentMethod = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment method not found"));
        return mapper.toDto(paymentMethod);
    }

    @Override
    public List<PaymentMethodDto> getAllPaymentMethods() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
