package com.tgt.corp.finance.repository;

import com.tgt.corp.finance.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "product", path="product")
@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Product findByProductId(Long id);
}
