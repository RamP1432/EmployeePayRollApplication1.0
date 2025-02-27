package com.example.employeepayrollapplication.controllers;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/EmployeePayRoll")
public class EmployeePayRollController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id/{myId}")
    public Optional<Employee> findById(@PathVariable int myId){
        return employeeService.getEmployeeById(myId);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);

    }

    @PutMapping("/update/{myId}")
    public Employee updateEmployee(@PathVariable int myId,@RequestBody Employee employee){
       return employeeService.updateEmployee(myId,employee);
    }

    @DeleteMapping("delete/{myId}")
    public String deleteEmployee(@PathVariable int myId){
        employeeService.deleteEmployee(myId);
        return "Employee is deleted.";
    }
}
