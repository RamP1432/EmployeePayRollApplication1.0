package com.example.employeepayrollapplication.services;

import lombok.extern.slf4j.Slf4j;
import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class EmployeeService {
        @Autowired
        private EmployeeRepository employeeRepository;

        public List<Employee> getAllEmployees() {
            log.info("Accessing all record of Employees.");
            return employeeRepository.findAll();
        }

        public Optional<Employee> getEmployeeById(int id) {

            return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> {
                log.error("Employee not found with ID: {}", id);
                return new RuntimeException("Employee not found");
            }));
        }

        public Employee addEmployee(Employee employee) {
            log.info("Adding new employee: {}", employee.getName());
            return employeeRepository.save(employee);
        }

        public Employee updateEmployee(int id, Employee employee) {
           log.warn("Updating employee with ID: {}", id);
            Employee employee1 = employeeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
            employee1.setSalary(employee.getId());
            employee1.setAge(employee.getAge());
            employee1.setName(employee.getName());
            return employeeRepository.save(employee1);
        }

        public void deleteEmployee(int id) {
            log.info("Deleting employee with ID: {}", id);
            employeeRepository.deleteById(id);
        }
}

