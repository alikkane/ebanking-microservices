package org.sid.customerservice.web.implementation;

import lombok.AllArgsConstructor;
import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.exceptions.CustomerNotFoundException;
import org.sid.customerservice.service.interfaces.ICustomerService;
import org.sid.customerservice.web.interfaces.ICustomerRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
public class CustomerRestController implements ICustomerRestController {
    private final ICustomerService customerService;

    @Override
    @GetMapping("/customers/{customerId}")
    public CustomerDTO findCustomerById(@PathVariable Long customerId) throws CustomerNotFoundException {
        return customerService.findCustomerById(customerId);
    }

    @Override
    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @Override
    @GetMapping("/customers")
    public List<CustomerDTO> findCustomers() {
        return customerService.getCustomers();
    }

    @Override
    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
