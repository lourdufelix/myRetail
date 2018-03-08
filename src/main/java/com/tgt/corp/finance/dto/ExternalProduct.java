package com.tgt.corp.finance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalProduct {


    @JsonProperty("item")
    private Item item;


    //Getters and Setters

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
