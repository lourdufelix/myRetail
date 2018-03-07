package com.tgt.corp.finance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackageDimensions {

    @JsonProperty("weight")
    private String weight;
    @JsonProperty("weight_unit_measure")
    private String weightUnitMeasure;
    @JsonProperty("width")
    private String width;
    @JsonProperty("depth")
    private String depth;
    @JsonProperty("height")
    private String height;
    @JsonProperty("dimension_unit_of_measure")
    private String dimentionUnitOfMeasure;

    //Getters and Setters
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightUnitMeasure() {
        return weightUnitMeasure;
    }

    public void setWeightUnitMeasure(String weightUnitMeasure) {
        this.weightUnitMeasure = weightUnitMeasure;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDimentionUnitOfMeasure() {
        return dimentionUnitOfMeasure;
    }

    public void setDimentionUnitOfMeasure(String dimentionUnitOfMeasure) {
        this.dimentionUnitOfMeasure = dimentionUnitOfMeasure;
    }
}
