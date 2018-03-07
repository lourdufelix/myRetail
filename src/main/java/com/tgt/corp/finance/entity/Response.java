package com.tgt.corp.finance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("product")
    private ExternalProduct externalProduct;

    //Getters and Setters


    public ExternalProduct getExternalProduct() {
        return externalProduct;
    }

    public void setExternalProduct(ExternalProduct externalProduct) {
        this.externalProduct = externalProduct;
    }
}
