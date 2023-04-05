package com.cybage.app.controller;

import com.cybage.app.entity.Employee;
import com.cybage.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public ResponseEntity<String> getHomePage() {
        return new ResponseEntity<>("Welcome to Homepage", HttpStatus.OK);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.getAllEmployees();
             if(employees.isEmpty()){
                   return new ResponseEntity<>(employees,HttpStatus.NO_CONTENT);
             }
             return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employee1=employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Integer id){
         Optional<Employee> employee2=employeeService.getEmployeeById(id);
         if(employee2.isPresent()){
             Employee employee1=employeeService.updateEmployee(employee,id);
             return new ResponseEntity<>(employee1,HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id){
           Optional<Employee> employee2=employeeService.getEmployeeById(id);
           if(employee2.isPresent()) {
                employeeService.deleteEmployee(id);
                 return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
           }
           return new ResponseEntity<>("ID Not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){
        Optional<Employee> employee=employeeService.getEmployeeById(id);
        if(employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
