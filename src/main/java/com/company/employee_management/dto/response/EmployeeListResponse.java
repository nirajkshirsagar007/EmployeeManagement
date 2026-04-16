package com.company.employee_management.dto.response;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeListResponse {
    private List<EmployeeResponse> employees;
}
