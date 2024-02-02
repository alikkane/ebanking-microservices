package org.sid.acountservice.mapper.interfaces;

import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.dtos.SavingAccountDTO;
import org.sid.acountservice.dtos.CurrentAccountDTO;
import org.sid.acountservice.entities.Account;
import org.sid.acountservice.entities.CurrentAccount;
import org.sid.acountservice.entities.SavingAccount;

public interface IAccountMapper {
    AccountDTO fromAccount(Account bankAccount);
    Account fromAccountDTO(AccountDTO bankAccountDTO);
    SavingAccountDTO fromSavingAccount(SavingAccount savingAccount);
    SavingAccount fromSavingAccountDTO(SavingAccountDTO savingAccountDTO);
    CurrentAccountDTO fromCurrentAccount(CurrentAccount currentAccount);
    CurrentAccount fromCurrentAccountDTO(CurrentAccountDTO currentAccountDTO);
}
