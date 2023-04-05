package com.cybage.app.service;

import com.cybage.app.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Integer id);

    Employee updateEmployee(Employee employee,Integer id);

    void deleteEmployee(Integer id);
}
