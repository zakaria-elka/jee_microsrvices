package com.mcsrvcp3.microservicepart3;

import com.mcsrvcp3.microservicepart3.Entities.Customer;
import com.mcsrvcp3.microservicepart3.Repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

public class Microservicepart3Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservicepart3Application.class, args);
    }
    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null,"Zakaria El Karmoudi","zakariaelk@email.com"));
            customerRepository.save(new Customer(null,"Ahmed Amine","ahmedamine@email.com"));
            customerRepository.save(new Customer(null,"Said Hamid","saidha@email.com"));
            customerRepository.findAll().forEach(customer -> System.out.println(customer));

         };
    }

}
