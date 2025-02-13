package org.example.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter public class Loan {
    private String loanId;
    private String userId;
    private double amount;
    private double interestRate;
    private int durationMonths;
    private Date startDate;
    private boolean isApproved;

    public Loan(String loanId, String userId, double amount, double interestRate, int durationMonths, Date startDate, boolean isApproved){
        this.loanId = loanId;
        this.userId = userId;
        this.amount = amount;
        this.interestRate = interestRate;
        this.durationMonths = durationMonths;
        this.startDate = startDate;
        this.isApproved = isApproved;
    }

    public double calculateTotalRepayment(){
        return amount + (amount * (interestRate / 100) * (durationMonths / 12));
    }

    @Override
    public String toString() {
        return "Loan{" + "loanId='" + loanId + "', userId='" + userId + "', amount=" + amount +
                ", interestRate=" + interestRate + ", durationMonths=" + durationMonths +
                ", startDate=" + startDate + ", isApproved=" + isApproved + "}";
    }
}