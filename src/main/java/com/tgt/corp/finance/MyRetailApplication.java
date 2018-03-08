package com.tgt.corp.finance;


import com.tgt.corp.finance.entity.Price;
import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.repository.ProductRepository;
import com.tgt.corp.finance.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
public class MyRetailApplication implements CommandLineRunner {

    @Autowired ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyRetailApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        productRepository.deleteAll();

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(13860428L, new Price(13.49, "USD")));
        products.add(new Product(15117729L, new Price(50.00, "USD")));
        products.add(new Product(16483589L, new Price(550.00, "USD")));
        products.add(new Product(16696652L, new Price(150.00, "USD")));
        products.add(new Product(16752456L, new Price(110.99, "USD")));
        products.add(new Product(15643793L, new Price(55.45, "USD")));

        productRepository.saveAll(products);

    }
}

