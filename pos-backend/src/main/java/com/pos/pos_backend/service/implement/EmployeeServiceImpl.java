package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Dto.EmployeeDto;
import com.pos.pos_backend.mapper.EmployeeMapper;
import com.pos.pos_backend.model.entity.Employee;
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

    @Override
    public EmployeeDto updateEmployeeById(Long empId, EmployeeDto updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(empId).orElseThrow();
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setSchedule(updatedEmployee.getSchedule());
        existingEmployee.setWorkShiftID(updatedEmployee.getWorkShiftID());
        existingEmployee.setManagerID(updatedEmployee.getManagerID());
        existingEmployee.setCv(updatedEmployee.getCv());
        existingEmployee.setPositionID(updatedEmployee.getPositionID());
        existingEmployee.setCompanyID(updatedEmployee.getCompanyID());
        existingEmployee.setResume(updatedEmployee.getResume());
        existingEmployee.setDayOff(updatedEmployee.getDayOff());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setMobile(updatedEmployee.getMobile());
        existingEmployee.setGender(updatedEmployee.getGender());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setBankAccount(updatedEmployee.getBankAccount());
        existingEmployee.setContact(updatedEmployee.getContact());
        existingEmployee.setStartWorkingDate(updatedEmployee.getStartWorkingDate());
        existingEmployee.setCreatedDate(updatedEmployee.getCreatedDate());
        existingEmployee.setUpdatedDate(updatedEmployee.getUpdatedDate());
        existingEmployee.setImage(updatedEmployee.getImage());
        Employee saveUpdateEmployee = employeeRepository.save(existingEmployee);
        return EmployeeMapper.mapToEmployeeDto(saveUpdateEmployee);
    }
}
