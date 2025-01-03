package com.pos.pos_backend.service;

import com.pos.pos_backend.model.Dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long id);
}
