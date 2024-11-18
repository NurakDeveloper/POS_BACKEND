package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.Dto.EmployeeDto;
import com.pos.pos_backend.mapper.EmployeeMapper;
import com.pos.pos_backend.model.Employee;
import com.pos.pos_backend.repository.EmployeeRepository;
import com.pos.pos_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository ;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveNewEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveNewEmployee);
    }

    @Override
    public void removeEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> listEmployee = employeeRepository.findAll();
        return listEmployee.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee getEmployee = employeeRepository.findById(id).orElseThrow();
        return EmployeeMapper.mapToEmployeeDto(getEmployee);
    }

    @Override
    public Integer totalEmployee() {
        return employeeRepository.countCustomer();
    }
}
