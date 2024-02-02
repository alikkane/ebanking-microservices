package org.sid.acountservice.entities;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity @AllArgsConstructor @NoArgsConstructor
public class CurrentAccount extends Account {
    private double overDraft;
}
