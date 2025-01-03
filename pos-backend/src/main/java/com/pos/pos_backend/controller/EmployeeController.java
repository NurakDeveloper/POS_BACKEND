package com.pos.pos_backend.controller;

import com.pos.pos_backend.model.Dto.EmployeeDto;
import com.pos.pos_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping("create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("count")
    public Integer getTotalEmployee(){
        return employeeService.totalEmployee();
    }
    @DeleteMapping("remove/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.removeEmployeeById(employeeId);
        return ResponseEntity.ok("ID Has Been Deleted +" + employeeId );
    }
    @GetMapping("list-employee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
    @PutMapping("update-employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId , @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmployeeById(empId , employeeDto));
    }

}

