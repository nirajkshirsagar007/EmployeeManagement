package com.company.employee_management.dto.request;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeUpdateRequest {

    private String name;
    private String role;
    private Integer salary;
    private String phone;
    private String email;
}
