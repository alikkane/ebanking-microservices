package org.sid.acountservice.service.implementation;

import lombok.AllArgsConstructor;
import org.sid.acountservice.clients.interfaces.ICustomerRestClient;
import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.dtos.CurrentAccountDTO;
import org.sid.acountservice.dtos.SavingAccountDTO;
import org.sid.acountservice.entities.Account;
import org.sid.acountservice.entities.CurrentAccount;
import org.sid.acountservice.entities.SavingAccount;
import org.sid.acountservice.enums.AccountStatus;
import org.sid.acountservice.enums.AccountType;
import org.sid.acountservice.exceptions.BankAccountNotFoundException;
import org.sid.acountservice.mapper.interfaces.IAccountMapper;
import org.sid.acountservice.model.Customer;
import org.sid.acountservice.repository.interfaces.IAccountRepository;
import org.sid.acountservice.service.interfaces.IAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;
    private IAccountMapper accountMapper;
    private ICustomerRestClient customerRestClient;

    @Override
    public List<AccountDTO> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOList = accounts.stream().map(account -> accountMapper.fromAccount(account)).collect(Collectors.toList());
        accountDTOList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountDTOList;
    }

    @Override
    public AccountDTO getAccountById(String accountId) throws BankAccountNotFoundException {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new BankAccountNotFoundException("ACCOUNT NOT FOUND"));
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return accountMapper.fromAccount(account);
    }

    @Override
    public SavingAccountDTO saveSavingAccount(double initialBalance, double interestRate, Long customerId) {
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountId(UUID.randomUUID().toString());
        savingAccount.setBalance(initialBalance);
        savingAccount.setInterestRate(interestRate);
        savingAccount.setType(AccountType.SAVING_ACCOUNT);
        savingAccount.setCurrency("EUR");
        savingAccount.setStatus(AccountStatus.CREATED);
        savingAccount.setCreatedAt(LocalDate.now());
        savingAccount.setCustomerId(customerId);
        savingAccount.setCustomer(buildCustomer(customerId));
        SavingAccount savedAccount = accountRepository.save(savingAccount);
        return accountMapper.fromSavingAccount(savedAccount);
    }

    @Override
    public CurrentAccountDTO saveCurrentAccount(double initialBalance, double overDraft, Long customerId) {
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountId(UUID.randomUUID().toString());
        currentAccount.setBalance(initialBalance);
        currentAccount.setOverDraft(overDraft);
        currentAccount.setType(AccountType.CURRENT_ACCOUNT);
        currentAccount.setCurrency("EUR");
        currentAccount.setStatus(AccountStatus.CREATED);
        currentAccount.setCreatedAt(LocalDate.now());
        currentAccount.setCustomerId(customerId);
        currentAccount.setCustomer(buildCustomer(customerId));
        CurrentAccount savedAccount = accountRepository.save(currentAccount);
        return accountMapper.fromCurrentAccount(savedAccount);
    }

    private Customer buildCustomer(Long customerId)  {
        // CALL customer microservice to get the customer info
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setFirstName("ayoub");
        customer.setLastName("Alikkane");
        customer.setEmail("ayoub@gmail.com");
        return customer;
    }
}
