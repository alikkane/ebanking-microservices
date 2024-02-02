package org.sid.customerservice.repository.interfaces;

import org.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository  extends JpaRepository<Customer, Long> {
}
