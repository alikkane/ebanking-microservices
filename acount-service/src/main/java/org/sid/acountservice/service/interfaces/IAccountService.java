package org.sid.acountservice.service.interfaces;

import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.dtos.CurrentAccountDTO;
import org.sid.acountservice.dtos.SavingAccountDTO;
import org.sid.acountservice.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> getAccounts();

    AccountDTO getAccountById(String accountId) throws BankAccountNotFoundException;

    SavingAccountDTO saveSavingAccount(double initialBalance, double interestRate, Long customerId);
    CurrentAccountDTO saveCurrentAccount(double initialBalance, double overDraft, Long customerId);
}
