package org.example.Database;

import org.example.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LoanJpainterface extends JpaRepository<Loan, String> {
    Optional<Loan> findByLoanId(String loanId);
    List<Loan> findByLoanType(@Param("loanType") String loanType);
    List<Loan> findByLoanHolderId(@Param("userId") String userId);
}