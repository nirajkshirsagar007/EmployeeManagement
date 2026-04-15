package com.company.employee_management.service.impl;

import com.company.employee_management.entity.Employee;
import com.company.employee_management.service.interfaces.EmployeeService;
import com.company.employee_management.dto.request.EmployeeCreateRequest;
import com.company.employee_management.dto.request.EmployeeUpdateRequest;
import com.company.employee_management.dto.response.EmployeeResponse;
import com.company.employee_management.exception.custom.ResourceNotFoundException;
import com.company.employee_management.mapper.EmployeeMapper;
import com.company.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse CreateEmployee(EmployeeCreateRequest request){
        Employee employee = EmployeeMapper.toEntity(request);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> GetAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();

    }
    @Override
    public EmployeeResponse getEmployeeById(Long id){
        Employee employee =  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+ id));

        return EmployeeMapper.toResponse(employee);
    }

    public EmployeeResponse updateEmployeeById(Long id, EmployeeUpdateRequest request){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not found with id: "+ id));

        employee.setEmp_name(request.getName());
        employee.setRole(request.getRole());
        employee.setSalary(request.getSalary());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());

        Employee updated = employeeRepository.save(employee);
        return EmployeeMapper.toResponse(updated);
    }

    @Override
    public EmployeeResponse deleteEmployeeById(Long id){
        Employee employee =  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+ id));
        employeeRepository.deleteById(id);
        return EmployeeMapper.toResponse(employee);
    }
}
