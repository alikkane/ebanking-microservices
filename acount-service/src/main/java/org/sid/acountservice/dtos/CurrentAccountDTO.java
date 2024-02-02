package org.sid.acountservice.dtos;

import lombok.Data;

@Data
public class CurrentAccountDTO extends AccountDTO {
    private double overDraft;
}
