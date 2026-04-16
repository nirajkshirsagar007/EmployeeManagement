package com.company.employee_management.controller;

import com.company.employee_management.service.interfaces.EmployeeService;
import com.company.employee_management.dto.request.EmployeeCreateRequest;
import com.company.employee_management.dto.request.EmployeeUpdateRequest;
import com.company.employee_management.dto.response.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //Create employee
    @PostMapping
    public ResponseEntity<EmployeeResponse> CreateEmployee(@RequestBody EmployeeCreateRequest request){
        EmployeeResponse response = employeeService.CreateEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
        List<EmployeeResponse> employees = employeeService.GetAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id ){
        EmployeeResponse response = employeeService.getEmployeeById( id);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeUpdateRequest request){
        EmployeeResponse response = employeeService.updateEmployeeById(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<EmployeeResponse>deleteEmployeeById(@PathVariable Long id){
        EmployeeResponse response = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(response);
    }

}
