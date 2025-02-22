package org.example.Service;

import org.example.Database.LoanJpainterface;
import org.example.Model.Loan;

import java.util.List;
import java.util.Optional;

public class LoanManagement {
    private LoanJpainterface loanRepo;

    public Optional<Loan> getLoanByLoanId(String loanId){
        return loanRepo.findByLoanId(loanId);
    }

    public List<Loan> getLoansByType(String loanType){
        return loanRepo.findByLoanType(loanType);
    }

    public List<Loan> getLoanByHolderId(String userId){
        return loanRepo.findByLoanHolderId(userId);
    }

    public Loan saveLoan(Loan loan){
        return loanRepo.save(loan);
    }

    public List<Loan> saveAllLoans(List<Loan> loans){
        return loanRepo.saveAll(loans);
    }

    public int deleteLoan(String loanId) {
        if (loanRepo.existsById(loanId)) {
            loanRepo.deleteById(loanId);
            return 0;
        }
        return 1;
    }
}