package com.company.employee_management.mapper;

import com.company.employee_management.entity.Employee;
import com.company.employee_management.dto.request.EmployeeCreateRequest;
import com.company.employee_management.dto.response.EmployeeResponse;

public class EmployeeMapper {
    // convert createRequest to entity
    public static Employee toEntity(EmployeeCreateRequest request){
        return Employee.builder()
                .emp_name(request.getName())
                .role(request.getRole())
                .salary(request.getSalary())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }
    // Convert Entity → Response DTO
    public static EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getEmp_name())
                .role(employee.getRole())
                .salary(employee.getSalary())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .build();
    }
}