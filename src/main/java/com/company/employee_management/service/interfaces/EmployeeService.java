package com.company.employee_management.service.interfaces;

import com.company.employee_management.dto.request.EmployeeCreateRequest;
import com.company.employee_management.dto.request.EmployeeUpdateRequest;
import com.company.employee_management.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse CreateEmployee(EmployeeCreateRequest request);
    List<EmployeeResponse> GetAllEmployees();
    EmployeeResponse getEmployeeById(Long id);
    EmployeeResponse deleteEmployeeById(Long id);
    EmployeeResponse updateEmployeeById(Long id, EmployeeUpdateRequest request);
}
