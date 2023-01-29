package org.sid.billingservice;

import org.sid.billingservice.Entities.Bill;
import org.sid.billingservice.Entities.ProductItem;
import org.sid.billingservice.feing.CustomerRestClient;
import org.sid.billingservice.feing.ProductItemRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
							CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient){
		return args -> {

			System.out.println("--------------here--------------------");

			Customer customer=customerRestClient.getCustomerById(1L);
			Customer customer2=customerRestClient.getCustomerById(2L);
			System.out.println(customer.getEmail());
			System.out.println("--------------done--------------------");

			Bill bill=billRepository.save(new Bill(null,new Date(),null, customer.getId(), customer));
			 

			PagedModel<Product> productPagedModel=productItemRestClient.pageProduct();

			productPagedModel.forEach(p->{
				ProductItem productItem=new ProductItem();
				productItem.setPrice(p.getPrice());
				productItem.setQuantity(new Random().nextInt(100));
				productItem.setBill(bill);



				productItem.setProductID(p.getId());
				productItemRepository.save(productItem);
			});



			System.out.println(customer.getName());
			System.out.println(customer.getEmail());


		};
	}

}
