package org.example.Database;

import org.example.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountJpaInterface extends JpaRepository<Account, String>{
    List<Account> findByAccountNumber(String accountNumber);
    Optional<Account> findByAccountId(String accountId);
    List<Account> findByAccountHolderId(@Param("userId") String userId);
    List<Account> findByBranchName(@Param("branchName") String branchName);
}