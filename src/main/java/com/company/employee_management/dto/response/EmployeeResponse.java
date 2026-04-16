package com.company.employee_management.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String role;
    private int salary;
    private String email;
    private String phone;

}
