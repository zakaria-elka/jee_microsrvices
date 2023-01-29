package com.invtnrysrc.inverntoryservice;

import com.invtnrysrc.inverntoryservice.Entities.Product;
import com.invtnrysrc.inverntoryservice.Reporitories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InverntoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InverntoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepo productRepo, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        productRepo.save(new Product(null,"Plastic Chair",23,43));
        productRepo.save(new Product(null,"Lamp",21,52));
        productRepo.save(new Product(null,"Wood Table",30,21));
        productRepo.findAll().forEach(product -> {System.out.println(product);});
        return null;
    }

}
