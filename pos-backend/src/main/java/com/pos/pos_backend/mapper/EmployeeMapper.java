package com.pos.pos_backend.mapper;

import com.pos.pos_backend.Dto.EmployeeDto;
import com.pos.pos_backend.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getSchedule(),
                employee.getWorkShiftID(),
                employee.getManagerID(),
                employee.getCv(),
                employee.getPositionID(),
                employee.getCompanyID(),
                employee.getResume(),
                employee.getDayOff(),
                employee.getEmail(),
                employee.getMobile(),
                employee.getGender(),
                employee.getSalary(),
                employee.getAddress(),
                employee.getBankAccount(),
                employee.getContact(),
                employee.getStartWorkingDate(),
                employee.getCreatedDate(),
                employee.getUpdatedDate(),
                employee.getImage()

        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getLastName(),
                employeeDto.getFirstName(),
                employeeDto.getSchedule(),
                employeeDto.getWorkShiftID(),
                employeeDto.getManagerID(),
                employeeDto.getCv(),
                employeeDto.getPositionID(),
                employeeDto.getCompanyID(),
                employeeDto.getResume(),
                employeeDto.getDayOff(),
                employeeDto.getEmail(),
                employeeDto.getMobile(),
                employeeDto.getGender(),
                employeeDto.getSalary(),
                employeeDto.getAddress(),
                employeeDto.getBankAccount(),
                employeeDto.getContact(),
                employeeDto.getStartWorkingDate(),
                employeeDto.getCreatedDate(),
                employeeDto.getUpdatedDate(),
                employeeDto.getImage()

        );
    }

}
