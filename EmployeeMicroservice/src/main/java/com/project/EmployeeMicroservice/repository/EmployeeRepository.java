package com.project.EmployeeMicroservice.repository;

import com.project.EmployeeMicroservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
