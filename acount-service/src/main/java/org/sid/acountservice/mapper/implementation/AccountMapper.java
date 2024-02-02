package org.sid.acountservice.mapper.implementation;

import lombok.AllArgsConstructor;
import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.dtos.CurrentAccountDTO;
import org.sid.acountservice.dtos.SavingAccountDTO;
import org.sid.acountservice.entities.Account;
import org.sid.acountservice.entities.CurrentAccount;
import org.sid.acountservice.entities.SavingAccount;
import org.sid.acountservice.mapper.interfaces.IAccountMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class AccountMapper implements IAccountMapper {

    @Override
    public AccountDTO fromAccount(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account, accountDTO);
        return accountDTO;
    }

    @Override
    public Account fromAccountDTO(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        return account;
    }

    @Override
    public SavingAccountDTO fromSavingAccount(SavingAccount savingAccount) {
        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        BeanUtils.copyProperties(savingAccount, savingAccountDTO);
        return savingAccountDTO;
    }

    @Override
    public SavingAccount fromSavingAccountDTO(SavingAccountDTO savingAccountDTO) {
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingAccountDTO, savingAccount);
        return savingAccount;
    }

    @Override
    public CurrentAccountDTO fromCurrentAccount(CurrentAccount currentAccount) {
        CurrentAccountDTO currentAccountDTO = new CurrentAccountDTO();
        BeanUtils.copyProperties(currentAccount, currentAccountDTO);
        return currentAccountDTO;
    }

    @Override
    public CurrentAccount fromCurrentAccountDTO(CurrentAccountDTO currentAccountDTO) {
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentAccountDTO, currentAccount);
        return currentAccount;
    }
}
