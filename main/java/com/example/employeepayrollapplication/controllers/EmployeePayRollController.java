package com.example.employeepayrollapplication.controllers;

import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/EmployeePayRoll")
public class EmployeePayRollController {
    @Autowired
    EmployeeService employeeService;
    Map<Integer,Employee> employeeList=new HashMap<>();
    @GetMapping("/getData")
    public List<Employee> getData(){
        System.out.println(employeeList.values());
        return new ArrayList<>(employeeList.values());
    }
    @PostMapping
    public String setData(@RequestBody Employee employee1){
        employeeList.put(employee1.getId(),employee1);
        return "Data is stored.";
    }
    @PutMapping("/id/{myId}")
    public String updateData(@PathVariable int myId,@RequestBody Employee employee1){
        employeeList.put(myId,employee1);
        return "Record updated.";
    }
    @DeleteMapping("/delete/{myId}")
    public String deleteData(@PathVariable int myId){
        if(employeeList.containsKey(myId)){
         employeeList.remove(myId);
         return myId+" Record is deleted successfully.";}
        return myId+" record not exist.";
    }
}
