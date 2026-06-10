package com.project.EmployeeMicroservice.service;

import com.project.EmployeeMicroservice.dto.EmployeeRequest;
import com.project.EmployeeMicroservice.entity.Employee;
import com.project.EmployeeMicroservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setAge(request.getAge());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByFirstName(name)
                .orElseThrow(() -> new RuntimeException("User by name is not present"));
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
