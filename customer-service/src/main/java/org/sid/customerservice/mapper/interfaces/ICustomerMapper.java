package org.sid.customerservice.mapper.interfaces;

import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.entities.Customer;

public interface ICustomerMapper {
    CustomerDTO fromCustomer(Customer customer);
    Customer fromCustomerDTO(CustomerDTO customerDTO);
}
