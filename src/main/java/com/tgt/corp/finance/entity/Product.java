package com.tgt.corp.finance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Product {

    @Id
    @Valid
    @Min(10000000)
    @Max(99999999)
    private Long productId;

    @Valid
    @NonNull
    private Price price;

    public Product(){}

    public Product(Long id, Price price){
        this.productId = id;
        this.price = price;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

}
