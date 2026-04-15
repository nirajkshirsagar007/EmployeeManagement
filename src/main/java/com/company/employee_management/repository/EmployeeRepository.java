package com.company.employee_management.repository;

import com.company.employee_management.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public class EmployeeRepository extends JpaRepository<Employee,Long> {
}
