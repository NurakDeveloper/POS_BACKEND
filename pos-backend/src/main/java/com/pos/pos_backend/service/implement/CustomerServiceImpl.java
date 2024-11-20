package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.CustomerDto;
import com.pos.pos_backend.mapper.CustomerMapper;
import com.pos.pos_backend.model.Customer;
import com.pos.pos_backend.repository.CustomerRepository;
import com.pos.pos_backend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        return CustomerMapper.mapToCustomerDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddressLine1(customerDto.getAddressLine1());
        customer.setAddressLine2(customerDto.getAddressLine2());
        customer.setCity(customerDto.getCity());
        customer.setState(customerDto.getState());
        customer.setPostalCode(customerDto.getPostalCode());
        customer.setCountry(customerDto.getCountry());
        customer.setJoinDate(customerDto.getJoinDate());
        customer.setMembershipStatus(customerDto.getMembershipStatus());
        customer.setStatus(customerDto.getStatus());
        return CustomerMapper.mapToCustomerDto(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return CustomerMapper.mapToCustomerDto(customerRepository.findById(id).orElseThrow());
    }
}
