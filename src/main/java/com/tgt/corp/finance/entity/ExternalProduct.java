package com.tgt.corp.finance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalProduct {

    @JsonProperty("local_product_details")
    private Product product;
    @JsonProperty("item")
    private Item item;


    //Getters and Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
