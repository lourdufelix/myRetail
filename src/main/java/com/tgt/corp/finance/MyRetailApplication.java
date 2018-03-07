package com.tgt.corp.finance;


import com.tgt.corp.finance.entity.Price;
import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MyRetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRetailApplication.class, args);

        ProductService productService = new ProductService();

        ArrayList<Object> ids = new ArrayList<>();
        ids.add(0, 15117729);

        //sample records insertions
        Product product = new Product((Long)ids.get(0), "Dishwasher", new Price(100.00, "USD"));

        productService.saveProductDetails(product);

    }
}
