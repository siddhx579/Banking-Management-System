package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public class Customer extends User{
    private String accountNumber;
    private double balance;

    public Customer(String id, String name, String email, String password, String accountNumber, double balance){
        super(id, name, email, password, "Customer");
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}