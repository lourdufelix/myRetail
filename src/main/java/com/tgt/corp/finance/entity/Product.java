package com.tgt.corp.finance.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by a515583 on 3/6/18.
 */
public class Product {

    @Id
    private Integer productId;

    private String name;
    private Price price;



    public Product(){}

    public Product(String name, Price price){
        this.name = name;
        this.price = price;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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
