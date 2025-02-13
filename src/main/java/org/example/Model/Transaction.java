package org.example.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private String type;
    private Date date;

    public Transaction(String transactionId, String accountNumber, double amount, String type, Date date){
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId='" + transactionId + "', accountNumber='" + accountNumber +
                "', amount=" + amount + ", type='" + type + "', date=" + date + "}";
    }
}
