package com.tgt.corp.finance.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class ProductDescription {

    @JsonProperty("title")
    private String title;
    @JsonProperty("general_description")
    private String generalDescription;
    @JsonProperty("bullet_description")
    private List<String> bulletDescriptions = new ArrayList<String>();



    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public List<String> getBulletDescriptions() {
        return bulletDescriptions;
    }

    public void setBulletDescriptions(List<String> bulletDescriptions) {
        this.bulletDescriptions = bulletDescriptions;
    }
}
