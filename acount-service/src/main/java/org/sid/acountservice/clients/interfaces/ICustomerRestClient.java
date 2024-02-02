package org.sid.acountservice.clients.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.acountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name="customer-service")
public interface ICustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name="customerService", fallbackMethod = "getAllCustomers")
    @GetMapping("/customers")
    List<Customer> findAllCustomers();

    default Customer getDefaultCustomer(Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Available");
        customer.setLastName("Not Available");
        customer.setEmail("Not Available");
        return customer;
    }
    default List<Customer> getAllCustomers() {
        return List.of();
    }
}
