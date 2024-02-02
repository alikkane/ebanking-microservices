package org.sid.acountservice.entities;


import jakarta.persistence.*;
import lombok.*;
import org.sid.acountservice.enums.AccountStatus;
import org.sid.acountservice.enums.AccountType;
import org.sid.acountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter
@Entity @AllArgsConstructor @NoArgsConstructor @Builder
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
