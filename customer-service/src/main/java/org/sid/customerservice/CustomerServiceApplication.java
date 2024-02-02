package org.sid.customerservice;

import org.sid.customerservice.dtos.CustomerDTO;
import org.sid.customerservice.service.interfaces.ICustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ICustomerService customerService) {
		return args -> {
			// 1 - Create customers // Functional Interface !!
			Stream.of("jad", "ayoub").forEach(name-> {
				CustomerDTO customer = new CustomerDTO();
				customer.setFirstName(name);
				customer.setLastName("Alikkane");
				customer.setEmail(name+".alikkane@gmail.com");
				customerService.saveCustomer(customer);
			});
		};
	}
}
