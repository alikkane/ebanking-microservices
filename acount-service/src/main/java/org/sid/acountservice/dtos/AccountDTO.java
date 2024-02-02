package org.sid.acountservice.dtos;

import lombok.Builder;
import lombok.Data;
import org.sid.acountservice.enums.AccountStatus;
import org.sid.acountservice.enums.AccountType;
import org.sid.acountservice.model.Customer;

import java.time.LocalDate;

@Data
public class AccountDTO {
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountStatus status;
    private AccountType type;
    private Long customerId;
    private Customer customer;
}
