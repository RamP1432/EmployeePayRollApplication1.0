package com.example.employeepayrollapplication.controllers;

import com.example.employeepayrollapplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EmployeePayRoll")
public class EmployeePayRollController {
    @Autowired
    Employee employee;


    @GetMapping
    public String getData(){
        return "Welcome in the EmployeePayRoll Application.\n Soon you will get data.";
    }
    @PostMapping
    public String setData(@RequestBody String msg){
        return "Data is stored.";
    }
    @PutMapping("/id/{myId}")
    public String updateData(@PathVariable int myId,@RequestBody String msg){
        return "Record updated.";
    }
    @DeleteMapping("/delete/{myId}")
    public String deleteData(@PathVariable int myId){
        return myId+" Record is deleted successfully.";
    }
}
