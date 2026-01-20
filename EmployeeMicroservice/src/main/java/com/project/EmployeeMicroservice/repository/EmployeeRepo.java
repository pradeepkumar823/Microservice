package com.project.EmployeeMicroservice.repository;

import com.project.EmployeeMicroservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
