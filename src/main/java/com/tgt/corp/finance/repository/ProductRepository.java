package com.tgt.corp.finance.repository;

import com.tgt.corp.finance.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by a515583 on 3/6/18.
 */

@RepositoryRestResource(collectionResourceRel = "product", path="product")
public interface ProductRepository extends MongoRepository<Product, Integer>{
    List<Product> findByProductId(@Param("id") Integer id);
}
