package com.company.employee_management.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeCreateRequest {
    private String name;
    private String role;
    private int salary;
    private String email;
    private String phone;

}