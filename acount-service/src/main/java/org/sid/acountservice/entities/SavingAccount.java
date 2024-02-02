package org.sid.acountservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sid.acountservice.enums.AccountStatus;
import org.sid.acountservice.enums.AccountType;
import org.sid.acountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter
@Entity @AllArgsConstructor @NoArgsConstructor
public class SavingAccount extends Account {
    private double interestRate;
}
