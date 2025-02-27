package com.example.employeepayrollapplication.controllers;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
@Slf4j
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



    @GetMapping("/log")
    public String testLogging() {
        log.debug("This is a DEBUG log - Only visible in dev");
        log.info("This is an INFO log - Always visible in production");
        log.warn("This is a WARN log - Warning messages");
        log.error("This is an ERROR log - Critical issues");

        return "Logging test completed!";
    }
}
