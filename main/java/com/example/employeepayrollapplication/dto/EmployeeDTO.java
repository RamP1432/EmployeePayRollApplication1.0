package com.example.employeepayrollapplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    public String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    public double salary;
    public int age;
    public int id;
}
