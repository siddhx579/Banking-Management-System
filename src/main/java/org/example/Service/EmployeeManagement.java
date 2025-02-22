package org.example.Service;

import org.example.Database.EmployeeJpainterface;
import org.example.Model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeManagement {
    private EmployeeJpainterface employeeRepo;

    public Optional<Employee> getEmployeeByUserId(String userId) {
        return employeeRepo.findByUserId(userId);
    }

    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepo.findByEmail(email);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepo.findByNameContaining(name);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    public void deleteEmployee(String userId) {
        employeeRepo.deleteById(userId);
    }
}