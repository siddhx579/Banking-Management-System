package org.example.Database;

import org.example.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanJpainterface extends JpaRepository<Loan, String> {
    List<Loan> findByLoanId(String loanId);
    List<Loan> findByHolder(String loanHolder);
    List<Loan> findByApprovedBy(String approvedBy);
}