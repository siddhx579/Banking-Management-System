package org.example.Database;

import org.example.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerJpaInterface extends JpaRepository<Customer, String> {
    Optional<Customer> findByUserId(String userId);
    Optional<Customer> findByEmail(String email);
    List<Customer> findByNameContaining(@Param("name") String name);
}