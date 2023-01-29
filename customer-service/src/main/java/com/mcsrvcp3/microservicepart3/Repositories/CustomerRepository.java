package com.mcsrvcp3.microservicepart3.Repositories;

import com.mcsrvcp3.microservicepart3.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
