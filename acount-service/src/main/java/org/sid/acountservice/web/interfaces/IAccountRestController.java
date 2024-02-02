package org.sid.acountservice.web.interfaces;

import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface IAccountRestController {
    List<AccountDTO> getAccounts();
    AccountDTO getAccountById(String accountId) throws BankAccountNotFoundException;
}
