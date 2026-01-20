package com.project.EmployeeMicroservice.controller;

import com.project.EmployeeMicroservice.dto.EmployeeRequest;
import com.project.EmployeeMicroservice.entity.Employee;
import com.project.EmployeeMicroservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody EmployeeRequest request) {

        Employee savedEmployee = employeeService.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee delete successfully");
    }
}
