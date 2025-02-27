package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
        @Autowired
        private EmployeeRepository repository;

        public List<Employee> getAllEmployees() {
            return repository.findAll();
        }

        public Employee getEmployeeById(int id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
        }

        public Employee addEmployee(Employee employee) {
            return repository.save(employee);
        }

        public Employee updateEmployee(int id, Employee employee) {
            Employee employee1 = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            employee1.setName(employee.getName());
            employee1.setSalary(employee.getSalary());
            employee1.setSalary(employee.getSalary());
            return repository.save(employee);
        }

        public void deleteEmployee(int id) {
            repository.deleteById(id);
        }

}
