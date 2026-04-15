package com.company.employee_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solve_emp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emp_name;

    private String role;

    private int salary;

    @Column(unique = true,nullable = false)
    private String email;

    private String phone;

}