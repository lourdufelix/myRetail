package com.tgt.corp.finance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tgt.corp.finance.dto.ExternalProduct;
import com.tgt.corp.finance.entity.Price;
import com.tgt.corp.finance.entity.Product;

public class ProductDetails {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("current_price")
    private Price price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
