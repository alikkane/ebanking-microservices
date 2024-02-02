package org.sid.customerservice.mapper.implementation;

import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.mapper.interfaces.ICustomerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper implements ICustomerMapper {
    @Override
    public CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    @Override
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
}
