package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor public class Loan {
    private String loanId;
    private String loanType;
    private double amount;
    private double interest;
    private User loanHolder;
    private User approvedBy;
    private boolean isDeleted;
}