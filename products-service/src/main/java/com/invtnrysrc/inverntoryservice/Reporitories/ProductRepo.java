package com.invtnrysrc.inverntoryservice.Reporitories;

import com.invtnrysrc.inverntoryservice.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepo extends JpaRepository<Product,Long> {
}
