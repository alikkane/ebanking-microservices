package org.sid.acountservice.web.implementation;

import lombok.AllArgsConstructor;
import org.sid.acountservice.clients.interfaces.ICustomerRestClient;
import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.exceptions.BankAccountNotFoundException;
import org.sid.acountservice.model.Customer;
import org.sid.acountservice.service.interfaces.IAccountService;
import org.sid.acountservice.web.interfaces.IAccountRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @AllArgsConstructor
public class AccountRestController implements IAccountRestController {

    private IAccountService accountService;
    @Override
    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }

    @Override
    @GetMapping("/accounts/{accountId}")
    public AccountDTO getAccountById(@PathVariable String accountId) throws BankAccountNotFoundException {
        return accountService.getAccountById(accountId);
    }
}
