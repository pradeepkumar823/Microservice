package com.project.EmployeeMicroservice.service;

import com.project.EmployeeMicroservice.dto.EmployeeRequest;
import com.project.EmployeeMicroservice.entity.Employee;
import com.project.EmployeeMicroservice.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setAge(request.getAge());
        return employeeRepository.save(employee); // returns Employee
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(int id){
        if(!employeeRepository.existsById(id)){
            throw new RuntimeException("Employee is not found with id:"+id);
        }
        employeeRepository.deleteById(id);
    }

}
