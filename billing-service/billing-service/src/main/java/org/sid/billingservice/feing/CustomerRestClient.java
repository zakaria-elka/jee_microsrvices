package org.sid.billingservice.feing;

import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-MICROSV")
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{id}")
     Customer getCustomerById(@PathVariable(name = "id") Long id);

}
