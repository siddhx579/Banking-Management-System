package org.example.Database;

import org.example.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeJpainterface extends JpaRepository<Employee, String> {
    Optional<Employee> findByUserId(String userId);
    Optional<Employee> findByEmail(String email);
    List<Employee> findByNameContaining(@Param("name") String name);
}