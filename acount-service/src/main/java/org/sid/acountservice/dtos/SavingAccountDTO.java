package org.sid.acountservice.dtos;

import lombok.Data;

@Data
public class SavingAccountDTO extends AccountDTO {
    private double interestRate;
}
