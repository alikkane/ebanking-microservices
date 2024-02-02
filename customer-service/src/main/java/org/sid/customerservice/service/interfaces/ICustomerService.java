package org.sid.customerservice.service.interfaces;

import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {
    CustomerDTO findCustomerById(Long customerId) throws CustomerNotFoundException;
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomers();
    void deleteCustomer(Long customerId);
}
