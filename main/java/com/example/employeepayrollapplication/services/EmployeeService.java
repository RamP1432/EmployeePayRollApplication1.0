package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
        @Autowired
        private EmployeeRepository employeeRepository;

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Optional<Employee> getEmployeeById(int id) {
            return employeeRepository.findById(id);
        }

        public Employee addEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }

        public Employee updateEmployee(int id, Employee employee) {
            Employee employee1 = employeeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
            employee1.setSalary(employee.getId());
            employee1.setAge(employee.getAge());
            employee1.setName(employee.getName());
            return employeeRepository.save(employee1);
        }

        public void deleteEmployee(int id) {
            employeeRepository.deleteById(id);
        }
}

