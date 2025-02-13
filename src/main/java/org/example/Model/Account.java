package org.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter class Account {
    private String accountNumber;
    private String userId;
    private String accountType;
    private double balance;

    public Account(String accountNumber, String userId, String accountType, double balance){
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber='" + accountNumber + "', userId='" + userId +
                "', balance=" + balance + ", accountType='" + accountType + "'}";
    }
}
