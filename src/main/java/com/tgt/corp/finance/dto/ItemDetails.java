package com.tgt.corp.finance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDetails {

    @JsonProperty("product")
    private ExternalProduct externalProduct;

    public ExternalProduct getExternalProduct() {
        return externalProduct;
    }

    public void setExternalProduct(ExternalProduct externalProduct) {
        this.externalProduct = externalProduct;
    }
}
