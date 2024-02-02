package org.sid.acountservice.repository.interfaces;

import org.sid.acountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, String> {
}
