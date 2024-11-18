package com.pos.pos_backend.service;

import com.pos.pos_backend.Dto.EmployeeDto;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    void removeEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById(Long id);
    Integer totalEmployee();
}
