package org.sid.customerservice.service.implementation;

import lombok.AllArgsConstructor;
import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.exceptions.CustomerNotFoundException;
import org.sid.customerservice.mapper.interfaces.ICustomerMapper;
import org.sid.customerservice.repository.interfaces.ICustomerRepository;
import org.sid.customerservice.service.interfaces.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository;
    private ICustomerMapper customerMapper;
    @Override
    public CustomerDTO findCustomerById(Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("CUSTOMER NOT FOUND"));
        return customerMapper.fromCustomer(customer);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer savedCustomer = customerRepository.save(customerMapper.fromCustomerDTO(customerDTO));
        return customerMapper.fromCustomer(savedCustomer);
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer -> customerMapper.fromCustomer(customer))).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
