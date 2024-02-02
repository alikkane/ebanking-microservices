package org.sid.customerservice.web.interfaces;

import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerRestController {
    CustomerDTO findCustomerById(Long customerId) throws CustomerNotFoundException;
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> findCustomers();
    void deleteCustomer(Long customerId);
}
