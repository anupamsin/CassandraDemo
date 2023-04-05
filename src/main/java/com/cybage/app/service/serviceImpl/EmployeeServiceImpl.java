package com.cybage.app.service.serviceImpl;

import com.cybage.app.entity.Employee;
import com.cybage.app.repository.EmployeeRepository;
import com.cybage.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        Employee employee1=new Employee();
        employee1.setId(id);
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        employee1.setEmail(employee.getEmail());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(Integer id) {
       employeeRepository.deleteById(id);
    }
}
