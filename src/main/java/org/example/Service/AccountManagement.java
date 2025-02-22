package org.example.Service;

import org.example.Database.AccountJpaInterface;
import org.example.Model.Account;

import java.util.List;
import java.util.Optional;

public class AccountManagement {
    private AccountJpaInterface accountRepo;

    public List<Account> getAccountsByNumber(String accountNumber) {
        return accountRepo.findByAccountNumber(accountNumber);
    }

    public Optional<Account> getAccountById(String accountId) {
        return accountRepo.findByAccountId(accountId);
    }

    public List<Account> getAccountsByHolderId(String userId) {
        return accountRepo.findByAccountHolderId(userId);
    }

    public List<Account> getAccountsByBranch(String branchName) {
        return accountRepo.findByBranchName(branchName);
    }

    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    public List<Account> saveAllAccounts(List<Account> accounts) {
        return accountRepo.saveAll(accounts);
    }

    public void deleteAccount(String accountId) {
        accountRepo.deleteById(accountId);
    }
}