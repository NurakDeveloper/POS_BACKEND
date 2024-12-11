package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.CustomerDto;
import com.pos.pos_backend.model.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddressLine1(),
                customer.getAddressLine2(),
                customer.getCity(),
                customer.getState(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getJoinDate(),
                customer.getMembershipStatus(),
                customer.getStatus(),
                customer.getImage()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPhoneNumber(),
                customerDto.getAddressLine1(),
                customerDto.getAddressLine2(),
                customerDto.getCity(),
                customerDto.getState(),
                customerDto.getPostalCode(),
                customerDto.getCountry(),
                customerDto.getJoinDate(),
                customerDto.getMembershipStatus(),
                customerDto.getStatus(),
                customerDto.getImage()
        );
    }
}
