package org.sid.billingservice.web;

import org.sid.billingservice.Entities.Bill;
import org.sid.billingservice.feing.CustomerRestClient;
import org.sid.billingservice.feing.ProductItemRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin("*")

public class BillingRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductItemRestClient productItemRestClient;

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        try{
            Bill bill=billRepository.findById(id).get();
            Customer customer=customerRestClient.getCustomerById(bill.getCustomerId());
            bill.setCustomer(customer);
            bill.getProductItems().forEach(p -> {
                Product product=productItemRestClient.getProductById(p.getProductID());
                p.setProduct(product);
                p.setProductName(product.getName());


            });
            return bill;

        }catch(Exception e){
            return null;
        }





    }

}
