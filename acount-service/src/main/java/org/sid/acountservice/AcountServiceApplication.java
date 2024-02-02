package org.sid.acountservice;

import org.sid.acountservice.clients.interfaces.ICustomerRestClient;
import org.sid.acountservice.dtos.AccountDTO;
import org.sid.acountservice.enums.AccountType;
import org.sid.acountservice.model.Customer;
import org.sid.acountservice.service.interfaces.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@EnableFeignClients
@SpringBootApplication
public class AcountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(IAccountService accountService, ICustomerRestClient customerRestClient) {
        return args -> {
            accountService.saveCurrentAccount(750000, Math.random() * 9000, 1L);
            accountService.saveSavingAccount(900870, 2.5, 1L);
            accountService.saveCurrentAccount(850000, Math.random() * 9000, 2L);
            accountService.saveSavingAccount(965000, 3.5, 2L);

            /*List<Customer> allCustomers = customerRestClient.getAllCustomers();
            allCustomers.forEach(customer -> {
                accountService.saveCurrentAccount(Math.random()*80000, Math.random()*1500, customer.getId());
                accountService.saveSavingAccount(Math.random()*80000, 2.5, customer.getId());
            });*/
        };
    }
}
