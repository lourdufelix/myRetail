package com.tgt.corp.finance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private Long productId;

    private String name;
    private Price price;

    public Product(){}

    public Product(Long id, String name, Price price){
        this.productId = id;
        this.name = name;
        this.price = price;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

}
