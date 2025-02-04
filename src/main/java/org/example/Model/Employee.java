package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class Employee extends User{
    private String employeeId;
    private String department;
    private double salary;

    public Employee(String id, String name, String email, String password, String employeeId, String department, double salary){
        super(id, name, email, password, "Employee");
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }
}