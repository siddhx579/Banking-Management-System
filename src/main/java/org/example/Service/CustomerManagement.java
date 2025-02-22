package org.example.Service;

import org.example.Database.CustomerJpaInterface;
import org.example.Model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerManagement {
    private CustomerJpaInterface customerRepo;

    public Optional<Customer> getCustomerByUserId(String userId){
        return customerRepo.findByUserId(userId);
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return customerRepo.findByEmail(email);
    }

    public List<Customer> getCustomerByName(String name){
        return customerRepo.findByNameContaining(name);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> saveAllCustomers(List<Customer> customers) {
        return customerRepo.saveAll(customers);
    }

    public void deleteCustomer(String userId) {
        customerRepo.deleteById(userId);
    }
}